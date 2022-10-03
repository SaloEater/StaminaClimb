package com.mineinabyss.staminaclimb

import com.mineinabyss.idofront.commands.execution.IdofrontCommandExecutor
import com.mineinabyss.idofront.commands.extensions.actions.playerAction
import com.mineinabyss.idofront.config.config
import com.mineinabyss.idofront.messaging.info
import com.mineinabyss.idofront.messaging.success
import com.mineinabyss.staminaclimb.nms.Tags

class StaminaCommands : IdofrontCommandExecutor() {
    override val commands = commands(staminaClimb) {
        "climb" {
            permission = "staminaclimb.toggle"
            playerAction {
                player.climbEnabled = !player.climbEnabled
                if (player.climbEnabled) Tags.enableClimb(player)
                player.info("Stamina and climbing system: ${if (player.climbEnabled) "ON" else "OFF"}!")
            }
        }
        "staminaclimb" {
            "reload" {
                action {
                    staminaClimb.config = config("config") { staminaClimb.fromPluginPath(loadDefault = true) }
                    sender.success("Config has been reloaded!")
                }
            }
        }
    }
}
