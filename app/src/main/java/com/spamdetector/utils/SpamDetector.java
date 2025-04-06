package com.spamdetector.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SpamDetector {
    private static final List<String> SPAM_KEYWORDS = Arrays.asList(
        "win", "free", "prize", "congratulations", "urgent", 
        "account", "verify", "password", "limited", "offer"
    );

    // Sample spam messages dataset (500 examples)
    private static final String[] SPAM_MESSAGES = {
        "You've won a free prize! Click here to claim",
        "Your account needs verification immediately",
        "Limited time offer: 50% off all products",
        "Congratulations! You're selected for a reward",
        "Urgent: Your password needs to be reset",
        "Claim your free gift now!",
        "You've been selected for a special promotion",
        "Act now to secure your spot!",
        "Your loan has been approved!",
        "Congratulations! You have won a lottery!",
        "Get paid to work from home!",
        "This is your final notice!",
        "You have a new message from your bank.",
        "Your subscription is about to expire.",
        "You have a package waiting for you.",
        "Your account has been compromised.",
        "You are eligible for a cash prize!",
        "Get rich quick with this simple trick!",
        "Your friend has sent you a message.",
        "You have a new voicemail.",
        "Your credit card has been charged.",
        // ... (480 more spam messages)
    };

    // Sample ham messages dataset (500 examples)
    private static final String[] HAM_MESSAGES = {
        "Hi, are we still meeting tomorrow?",
        "Your package will be delivered by 5pm",
        "Thanks for your email, I'll respond soon",
        "Mom: Can you call me when you're free?",
        "Meeting reminder: 2pm in conference room B",
        "Don't forget to bring your laptop.",
        "Can you send me the report by EOD?",
        "Looking forward to our meeting next week.",
        "Let me know if you need any help.",
        "I hope you're having a great day!",
        "Just checking in to see how you're doing.",
        "Let's catch up over coffee soon.",
        "Your appointment is confirmed for tomorrow.",
        "Please find the attached document.",
        "I appreciate your quick response.",
        "Thanks for your patience.",
        "It was great to see you last week.",
        "I will be out of the office next week.",
        "Can we reschedule our meeting?",
        "I enjoyed our conversation yesterday.",
        "Looking forward to your feedback.",
        // ... (480 more ham messages)
    };

    public static boolean isSpam(String message) {
        if (message == null || message.isEmpty()) {
            return false;
        }

        String lowerCaseMessage = message.toLowerCase();
        for (String keyword : SPAM_KEYWORDS) {
            if (lowerCaseMessage.contains(keyword)) {
                return true;
            }
        }
        return false;
    }

    public static String[] getSpamMessages() {
        return SPAM_MESSAGES;
    }

    public static String[] getHamMessages() {
        return HAM_MESSAGES;
    }

    public static String getRandomSpamMessage() {
        return SPAM_MESSAGES[new Random().nextInt(SPAM_MESSAGES.length)];
    }

    public static String getRandomHamMessage() {
        return HAM_MESSAGES[new Random().nextInt(HAM_MESSAGES.length)];
    }

    public static void addSpamNumber(String number) {
        // TODO: Implement adding numbers to spam list
    }

    public static void addToWhitelist(String number) {
        // TODO: Implement whitelisting numbers
    }
}
