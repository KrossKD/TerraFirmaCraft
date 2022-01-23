package net.dries007.tfc.common.fluids;

import java.util.Locale;

public enum SimpleFluid
{
    BRINE(0xFFDCD3C9),
    CURDLED_MILK(0xFFFFFBE8),
    LIMEWATER(0xFFB4B4B4),
    LYE(0xFFfeffde),
    MILK_VINEGAR(0xFFFFFBE8),
    OLIVE_OIL(0xFF6A7537),
    OLIVE_OIL_WATER(0xFF4A4702),
    TANNIN(0xFF63594E),
    VINEGAR(0xFFC7C2AA);

    private final String id;
    private final int color;

    SimpleFluid(int color)
    {
        this.id = name().toLowerCase(Locale.ROOT);
        this.color = color;
    }

    public String getId()
    {
        return id;
    }

    public int getColor()
    {
        return color;
    }
}
