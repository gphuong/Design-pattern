package com.gpcoder.patterns.creational.abstractfactory.factory;

import com.gpcoder.patterns.creational.abstractfactory.MaterialType;
import com.gpcoder.patterns.creational.abstractfactory.factory.impl.PlasticFactory;
import com.gpcoder.patterns.creational.abstractfactory.factory.impl.WoodFactory;

public class FurnitureFactory {
    public FurnitureFactory() {
    }

    public static FurnitureAbstractFactory getFactory(MaterialType materialType) {
        switch (materialType) {
            case PLASTIC:
                return new PlasticFactory();
            case WOOD:
                return new WoodFactory();
            default:
                throw new UnsupportedOperationException("This furniture is unsupported");
        }
    }
}
