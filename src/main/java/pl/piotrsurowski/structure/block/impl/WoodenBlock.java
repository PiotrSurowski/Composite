package pl.piotrsurowski.structure.block.impl;

import pl.piotrsurowski.structure.block.Block;

public class WoodenBlock implements Block {
    @Override
    public String getColor() {
        return "Brown";
    }

    @Override
    public String getMaterial() {
        return "Wood";
    }
}
