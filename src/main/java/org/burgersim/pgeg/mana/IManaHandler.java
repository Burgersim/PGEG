package org.burgersim.pgeg.mana;

public interface IManaHandler {
    void setMana(float mana);
    void setMaxMana(float maxMana);

    float getMana();
    float getMaxMana();
}
