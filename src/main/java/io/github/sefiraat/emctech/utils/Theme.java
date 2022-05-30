package io.github.sefiraat.emctech.utils;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.List;

public enum Theme {
    WARNING(ChatColor.YELLOW, "警告"),
    ERROR(ChatColor.RED, "错误"),
    NOTICE(ChatColor.WHITE, "提示"),
    PASSIVE(ChatColor.GRAY, ""),
    SUCCESS(ChatColor.GREEN, "成功"),
    MAIN(ChatColor.of("#21588f"), "EMC科技"),
    CLICK_INFO(ChatColor.of("#e4ed32"), "点击此处"),
    RESEARCH(ChatColor.of("#a60e03"), "研究"),
    CRAFTING(ChatColor.of("#dbcea9"), "合成材料"),
    RECIPE_TYPE(ChatColor.of("#ffe89c"), "配方"),
    MACHINE(ChatColor.of("#3295a8"), "机器");

    protected static final Theme[] cachedValues = values();
    private final ChatColor color;
    private final String loreLine;

    @ParametersAreNonnullByDefault
    Theme(ChatColor color, String loreLine) {
        this.color = color;
        this.loreLine = loreLine;
    }

    public String color(String string) {
        return this + string;
    }

    public static Theme[] getCachedValues() {
        return cachedValues;
    }

    /**
     * Gets a SlimefunItemStack with a pre-populated lore and name with themed colors.
     *
     * @param id        The ID for the new {@link SlimefunItemStack}
     * @param itemStack The vanilla {@link ItemStack} used to base the {@link SlimefunItemStack} on
     * @param themeType The {@link Theme} {@link ChatColor} to apply to the {@link SlimefunItemStack} name
     * @param name      The name to apply to the {@link SlimefunItemStack}
     * @param lore      The lore lines for the {@link SlimefunItemStack}. Lore is book-ended with empty strings.
     * @return Returns the new {@link SlimefunItemStack}
     */
    @Nonnull
    @ParametersAreNonnullByDefault
    public static SlimefunItemStack themedSlimefunItemStack(String id,
                                                            ItemStack itemStack,
                                                            Theme themeType,
                                                            String name,
                                                            String... lore
    ) {
        ChatColor passiveColor = Theme.PASSIVE.getColor();
        List<String> finalLore = new ArrayList<>();
        finalLore.add("");
        for (String s : lore) {
            finalLore.add(passiveColor + s);
        }
        finalLore.add("");
        finalLore.add(applyThemeToString(Theme.CLICK_INFO, themeType.getLoreLine()));
        return new SlimefunItemStack(
            id,
            itemStack,
            Theme.applyThemeToString(themeType, name),
            finalLore.toArray(new String[finalLore.size() - 1])
        );
    }

    public static String producesIntro() {
        return Theme.SUCCESS + "Produces (per universe tick)";
    }

    public static String consumesIntro() {
        return Theme.ERROR + "Consumes (per universe tick)";
    }

    public static String modifiesIntro() {
        return Theme.SUCCESS + "Applies Modifiers";
    }

    public static String infoLinePassive(String title, String content) {
        return Theme.CLICK_INFO + title + ": " + Theme.PASSIVE + content;
    }

    public ChatColor getColor() {
        return color;
    }

    /**
     * Applies the theme color to a given string
     *
     * @param themeType The {@link Theme} to apply the color from
     * @param string    The string to apply the color to
     * @return Returns the string provides preceded by the color
     */
    @Nonnull
    @ParametersAreNonnullByDefault
    public static String applyThemeToString(Theme themeType, String string) {
        return themeType.getColor() + string;
    }

    public String getLoreLine() {
        return loreLine;
    }

    /**
     * Gets an ItemStack with a pre-populated lore and name with themed colors.
     *
     * @param material  The {@link Material} used to base the {@link ItemStack} on
     * @param themeType The {@link Theme} {@link ChatColor} to apply to the {@link ItemStack} name
     * @param name      The name to apply to the {@link ItemStack}
     * @param lore      The lore lines for the {@link ItemStack}. Lore is book-ended with empty strings.
     * @return Returns the new {@link ItemStack}
     */
    @Nonnull
    @ParametersAreNonnullByDefault
    public static ItemStack themedItemStack(Material material, Theme themeType, String name, String... lore) {
        ChatColor passiveColor = Theme.PASSIVE.getColor();
        List<String> finalLore = new ArrayList<>();
        finalLore.add("");
        for (String s : lore) {
            finalLore.add(passiveColor + s);
        }
        finalLore.add("");
        finalLore.add(applyThemeToString(Theme.CLICK_INFO, themeType.getLoreLine()));
        return new CustomItemStack(
            material,
            Theme.applyThemeToString(themeType, name),
            finalLore.toArray(new String[finalLore.size() - 1])
        );
    }

    @Nonnull
    public Particle.DustOptions getDustOptions(float size) {
        return new Particle.DustOptions(
            Color.fromRGB(
                color.getColor().getRed(),
                color.getColor().getGreen(),
                color.getColor().getBlue()
            ),
            size
        );
    }

    @Override
    public String toString() {
        return this.color.toString();
    }
}
