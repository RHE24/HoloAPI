package com.dsh105.holoapi.util;

import com.dsh105.holoapi.HoloAPI;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public enum Lang {

    //PREFIX("prefix", "&e[&9HoloAPI&e] &r••• "),

    UPDATE_NOT_AVAILABLE("update_not_available", "&3An update is not available."),
    NO_PERMISSION("no_permission", "&3You are not permitted to do that."),
    COMMAND_ERROR("cmd_error", "&3Error for input string: &b%cmd%&3. Use &b/" + HoloAPI.getInstance().getCommandLabel() + " help &3for help."),
    HELP_INDEX_TOO_BIG("help_index_too_big", "&3Page &b%index% &3does not exist."),
    IN_GAME_ONLY("in_game_only", "&3Please log in to do that."),
    STRING_ERROR("string_error", "&3Error parsing &b%string%&3. Please revise command arguments."),
    NULL_PLAYER("null_player", "&b%player% &3is not online. Please try a different Player."),
    INT_ONLY("int_only", "&b%string% &3must to be an integer."),
    WHUPS("whups", "&3Whups. Something bad happened."),
    CONFIGS_RELOADED("configs_reloaded", "&3Configuration files reloaded."),

    TIP_HOVER_PREVIEW("hover_tip", "&e&oHover over to see a preview of the hologram. Click to insert teleport command."),
    IMAGE_LOADED("url_image_loaded", "&3Custom URL image of key &b%key% loaded."),
    LOADING_URL_IMAGE("loading_url_image", "&3Loading custom URL image of key &b%key%&3. Create hologram when the image has finished loading."),
    LOADING_URL_ANIMATION("loading_url_animation", "&3Loading custom URL animation of key &b%key%&3. Create hologram when the animation has finished loading."),
    ACTIVE_DISPLAYS("active_displays", "&3Active Holographic Displays:"),
    IMAGES_NOT_LOADED("images_not_loaded", "&3Images are not loaded yet. Try again later."),

    FAILED_IMAGE_LOAD("failed_image_load", "&3Failed to load custom image. Make sure that it is correctly configured in &bconfig.yml&3."),
    IMAGE_NOT_FOUND("image_not_found", "&3Image &3not found. Use &b/holo build image &3to create a new image configuration."),
    HOLOGRAM_NOT_FOUND("hologram_not_found", "&3Hologram of ID &b%id% &3not found."),
    NO_ACTIVE_HOLOGRAMS("no_active_holograms", "&3There are currently no active holographic displays."),
    HOLOGRAM_CREATED("hologram_created", "&3Hologram of ID &b%id% &3created."),
    HOLOGRAM_REMOVED_MEMORY("hologram_removed_memory", "&3Hologram of ID &b%id% &3removed from memory."),
    HOLOGRAM_CLEARED_FILE("hologram_cleared_file", "&3Hologram of ID &b%id% &3cleared from file and memory."),
    HOLOGRAM_MOVED("hologram_moved", "&3Hologram position moved."),
    HOLOGRAM_RELOAD("hologram_reload", "&3Performing manual reload of all holograms and images..."),
    HOLOGRAM_TELEPORT_TO("hologram_teleport_to", "&3You have been teleported to the hologram of ID &b%id%&3."),

    YES_NO_INPUT_INVALID("yes_no_input_invalid", "&3Please enter either &bYes &3or &bNo&3."),
    YES_NO_CLEAR_FROM_FILE("yes_no_clear_from_file", "&3Would you like to clear this hologram from the save file? Please enter either &bYes &3or &bNo&3."),

    PROMPT_INPUT("prompt_input", "&3Enter the desired lines of the new hologram. Enter &bDone &3when finished."),
    PROMPT_INPUT_NEXT("prompt_input_next", "&3Added new line: &r%input%&3. Enter next line."),
    PROMPT_INPUT_FAIL("prompt_input_fail", "&3Hologram lines cannot be empty. Retry or enter &bExit &3 to cancel."),

    BUILDER_EMPTY_LINES("hologram_not_created", "&3The hologram was not created as it was empty."),
    BUILDER_INPUT_FAIL_TEXT_IMAGE("builder_input_fail_text_image", "&3Enter a valid line type (&bText &3or &bImage&3)."),
    BUILDER_INPUT_FIRST("builder_input_fail_text_image", "&3Enter type for next line (&bText &3or &bImage&3)."),
    BUILDER_INPUT_LINE_DATA("builder_input_line_data", "&3What would you like this line to say?"),
    BUILDER_INPUT_IMAGE_PATH("builder_input_image_path", "&3What image do you want to add?"),
    BUILDER_INPUT_NEXT_WITH_NUMBER("builder_input_next_with_number", "&3Added %line% line. Enter type for next line (&bText &3 or &bImage)."),;

    private String path;
    private String def;
    private String[] desc;

    Lang(String path, String def, String... desc) {
        this.path = path;
        this.def = def;
        this.desc = desc;
    }

    public String[] getDescription() {
        return this.desc;
    }

    public String getPath() {
        return this.path;
    }

    public String getDefault() {
        return def;
    }

    public static void sendTo(CommandSender sender, String msg) {
        if (msg != null || !msg.equalsIgnoreCase("") && !msg.equalsIgnoreCase(" ") && !msg.equalsIgnoreCase("none")) {
            sender.sendMessage(HoloAPI.getInstance().getPrefix() + msg);
        }
    }

    public static void sendTo(Player p, String msg) {
        if (msg != null && !msg.equalsIgnoreCase("") && !msg.equalsIgnoreCase(" ") && !(msg.equalsIgnoreCase("none"))) {
            p.sendMessage(HoloAPI.getInstance().getPrefix() + msg);
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String getValue() {
        String result = HoloAPI.getInstance().getConfig(HoloAPI.ConfigType.LANG).getString(this.path, this.def);
        if (result != null && result != "" && result != "none") {
            return ChatColor.translateAlternateColorCodes('&', HoloAPI.getInstance().getConfig(HoloAPI.ConfigType.LANG).getString(this.path, this.def));
        } else {
            return "";
        }
    }

    public String getRaw() {
        return HoloAPI.getInstance().getConfig(HoloAPI.ConfigType.LANG).getString(this.path, this.def);
    }
}