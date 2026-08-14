package fr.fifoube.main.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import fr.fifoube.main.ModEconomyInc;
import fr.fifoube.main.capabilities.CapabilityMoney;
import fr.fifoube.main.util.MoneyFormatter; // <-- AJOUT DE L'IMPORT
import java.util.Collection;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.text.TranslationTextComponent;

public class CommandBalance {
   public static void register(CommandDispatcher<CommandSource> dispatcher) {
      dispatcher.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)LiteralArgumentBuilder.literal("balance").requires((src) -> src.func_197034_c(2))).then(Commands.func_197057_a("add").then(Commands.func_197056_a("players", EntityArgument.func_197094_d()).then(Commands.func_197056_a("money", DoubleArgumentType.doubleArg((double)0.0F)).executes((ctx) -> addToBalance((CommandSource)ctx.getSource(), EntityArgument.func_197087_c(ctx, "players"), DoubleArgumentType.getDouble(ctx, "money"))))))).then(Commands.func_197057_a("remove").then(Commands.func_197056_a("players", EntityArgument.func_197094_d()).then(Commands.func_197056_a("money", DoubleArgumentType.doubleArg((double)0.0F)).executes((ctx) -> removeFromBalance((CommandSource)ctx.getSource(), EntityArgument.func_197087_c(ctx, "players"), DoubleArgumentType.getDouble(ctx, "money"))))))).then(Commands.func_197057_a("check").then(Commands.func_197056_a("players", EntityArgument.func_197094_d()).executes((ctx) -> checkFromBalance((CommandSource)ctx.getSource(), EntityArgument.func_197087_c(ctx, "players"))))));
   }

   private static int addToBalance(CommandSource src, Collection<? extends Entity> targets, double money) {
      targets.forEach((e) -> {
         if (e instanceof PlayerEntity) {
            ServerPlayerEntity playerMP = (ServerPlayerEntity)e;
            playerMP.getCapability(CapabilityMoney.MONEY_CAPABILITY, (Direction)null).ifPresent((data) -> {
               ModEconomyInc.LOGGER.info(playerMP.func_145748_c_().getString() + " has received " + money + ". Balance was at " + data.getMoney() + ", balance is now " + (data.getMoney() + money) + ".[UUID: " + playerMP.func_110124_au() + ",Command exectuor: " + src.func_197019_b().getString() + ", UUID: " + src.func_197022_f().func_110124_au() + "]");
               data.setMoney(data.getMoney() + money);
            });
            // Modifié : MoneyFormatter appliqué sur 'money'
            src.func_197030_a(new TranslationTextComponent("commands.balance.added", new Object[]{MoneyFormatter.format(money), playerMP.func_145748_c_().getString()}), false);
         }

      });
      return 0;
   }

   private static int removeFromBalance(CommandSource src, Collection<? extends Entity> targets, double money) {
      targets.forEach((e) -> {
         if (e instanceof PlayerEntity) {
            ServerPlayerEntity playerMP = (ServerPlayerEntity)e;
            playerMP.getCapability(CapabilityMoney.MONEY_CAPABILITY, (Direction)null).ifPresent((data) -> {
               ModEconomyInc.LOGGER.info(playerMP.func_145748_c_().getString() + " has been withdrawn " + money + ". Balance was at " + data.getMoney() + ", balance is now " + (data.getMoney() - money) + ".[UUID: " + playerMP.func_110124_au() + ",Command exectuor: " + src.func_197019_b().getString() + ", UUID: " + src.func_197022_f().func_110124_au() + "]");
               data.setMoney(data.getMoney() - money);
            });
            // Modifié : MoneyFormatter appliqué sur 'money'
            src.func_197030_a(new TranslationTextComponent("commands.balance.withdraw", new Object[]{MoneyFormatter.format(money), playerMP.func_145748_c_().getString()}), false);
         }

      });
      return 0;
   }

   private static int checkFromBalance(CommandSource src, Collection<? extends Entity> targets) {
      targets.forEach((e) -> {
         if (e instanceof PlayerEntity) {
            ServerPlayerEntity playerMP = (ServerPlayerEntity)e;
            // Modifié : MoneyFormatter appliqué sur 'data.getMoney()'
            playerMP.getCapability(CapabilityMoney.MONEY_CAPABILITY, (Direction)null).ifPresent((data) -> src.func_197030_a(new TranslationTextComponent("commands.balance.funds", new Object[]{playerMP.func_145748_c_().getString(), MoneyFormatter.format(data.getMoney())}), false));
         }

      });
      return 0;
   }
}
