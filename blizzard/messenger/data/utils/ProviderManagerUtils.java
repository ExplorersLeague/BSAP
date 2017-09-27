package com.blizzard.messenger.data.utils;

import com.blizzard.messenger.data.xmpp.extension.BlizzardDeliveryReceipt.Provider;
import com.blizzard.messenger.data.xmpp.extension.CarbonExtension.Provider;
import com.blizzard.messenger.data.xmpp.extension.MessageExtension.Provider;
import com.blizzard.messenger.data.xmpp.extension.PresenceExtension.Provider;
import com.blizzard.messenger.data.xmpp.extension.RosterExtension.Provider;
import com.blizzard.messenger.data.xmpp.provider.ActiveChatMessagesPacketProvider;
import com.blizzard.messenger.data.xmpp.provider.BlizzardRosterPacketProvider;
import com.blizzard.messenger.data.xmpp.provider.ChatHistoryPacketProvider;
import com.blizzard.messenger.data.xmpp.provider.ProfilePacketProvider;
import com.blizzard.messenger.data.xmpp.provider.SettingsPacketProvider;
import com.blizzard.messenger.data.xmpp.provider.SuggestedFriendsPacketProvider;
import com.blizzard.messenger.data.xmpp.provider.ViewFriendsProvider;
import org.jivesoftware.smack.provider.ProviderManager;
import org.jivesoftware.smackx.receipts.DeliveryReceipt.Provider;

public class ProviderManagerUtils
{
  public static void setupProviderManager()
  {
    ProviderManager.removeIQProvider("query", "jabber:iq:roster");
    ProviderManager.addIQProvider("query", "jabber:iq:roster", new BlizzardRosterPacketProvider());
    ProviderManager.addIQProvider("query", "blz:profile:simple", new ProfilePacketProvider());
    ProviderManager.addIQProvider("query", "blz:settings", new SettingsPacketProvider());
    ProviderManager.addExtensionProvider("meta", "blz:roster:item:meta", new RosterExtension.Provider());
    ProviderManager.addIQProvider("query", "blz:suggested:friends", new SuggestedFriendsPacketProvider());
    ProviderManager.addIQProvider("query", "blz:fof", new ViewFriendsProvider());
    ProviderManager.addIQProvider("query", "blz:convo:history", new ChatHistoryPacketProvider());
    ProviderManager.addIQProvider("query", "blz:convo:active", new ActiveChatMessagesPacketProvider());
    ProviderManager.addExtensionProvider("blz", "blz:presence", new PresenceExtension.Provider());
    ProviderManager.addExtensionProvider("meta", "blz:message:meta", new MessageExtension.Provider());
    ProviderManager.addExtensionProvider("received", "urn:xmpp:receipts", new DeliveryReceipt.Provider());
    ProviderManager.addExtensionProvider("meta", "blz:receipts", new BlizzardDeliveryReceipt.Provider());
    ProviderManager.addExtensionProvider("sent", "urn:xmpp:carbons:2", new CarbonExtension.Provider());
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/utils/ProviderManagerUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */