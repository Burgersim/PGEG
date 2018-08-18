package org.burgersim.pgeg.mana;

public interface IManaHandler {
    void setMana(float mana);
    void setMaxMana(float maxMana);

    void regenMana(float mana);

    float getMana();
    float getMaxMana();
}
