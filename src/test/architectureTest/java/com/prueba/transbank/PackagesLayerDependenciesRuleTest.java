package com.prueba.transbank;

import com.prueba.transbank.importoption.DontIncludeTests;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import com.tngtech.archunit.library.dependencies.SlicesRuleDefinition;
import org.junit.runner.RunWith;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "com.prueba.transbank", importOptions = DontIncludeTests.class)
public class PackagesLayerDependenciesRuleTest {

    @ArchTest
    public static final ArchRule entitiesShouldNotDependOnOtherPackages =
            ArchRuleDefinition.classes().that().resideInAPackage("..domain.entities..")
                    .should().dependOnClassesThat().resideInAnyPackage("..domain.entities..", "java..");

    @ArchTest
    public static final ArchRule domainShouldNotDependOnOtherPackages =
            ArchRuleDefinition.noClasses().that().resideInAnyPackage("..transbank.domain..")
                    .should().dependOnClassesThat().resideOutsideOfPackages("..transbank.domain..", "java..", "org.slf4j..", "");


    @ArchTest
    public static final ArchRule usecaseShouldResideInDomainPackage =
            ArchRuleDefinition.classes().that().resideInAPackage("..usecase")
                    .should().dependOnClassesThat().resideInAnyPackage("..domain..");

    @ArchTest
    public static final ArchRule useCaseShouldOnlyBeAccessedByEntrypointsOrOtherUsecaseOrSpringConfigure =
            ArchRuleDefinition.classes().that().resideInAPackage("..usecase..")
                    .should().onlyBeAccessed().byAnyPackage( "..usecase..", "..entrypoints..","..infrastructure.configuration..");



    @ArchTest
    public static final ArchRule errorShouldDependOnModel =
            ArchRuleDefinition.classes().that().resideInAnyPackage("..error..")
                    .should().dependOnClassesThat()
                    .resideInAnyPackage("..model..","..error..","java..");

    @ArchTest
    static final ArchRule controllersMustBePlacedInEntrypointsPackage =
            ArchRuleDefinition.classes().that().areAnnotatedWith(RestController.class)
                    .or().areAnnotatedWith(ControllerAdvice.class)
                    .should().resideInAPackage("..entrypoints.rest..");

    @ArchTest
    static final ArchRule infrastructureClassesShouldNotBeAccessedOutsideInfrastructure =
            ArchRuleDefinition.classes().that().resideInAPackage("..infrastructure..")
                    .should().onlyBeAccessed().byAnyPackage("..infrastructure..");

    @ArchTest public static final ArchRule verifyNoCycles = SlicesRuleDefinition.slices().matching("..error..")
            .should().notDependOnEachOther();

}