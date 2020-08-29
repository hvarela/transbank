package com.prueba.transbank.importoption;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.core.importer.Location;

public class DontIncludeTests implements ImportOption {
    @Override
    public boolean includes(Location location) {
        return !(location.contains("/unitTest/") ||
                location.contains("/commons/")
        );
    }
}
