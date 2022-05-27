package PG;

public class PG_17683 {
    class Music{
        String startTime, endTime;
        String title, sheet;
        String melody = "";
        int playTime;

        public Music(String startTime, String endTime, String title, String sheet){
            this.startTime = startTime;
            this.endTime = endTime;
            this.title = title;
            this.sheet = sheet;
            calPlayTimeMinute();
            calMelody();
        }

        void calPlayTimeMinute() {
            String[] startToken = this.startTime.split(":");
            String[] endToken = this.endTime.split(":");
            int startHour = Integer.parseInt(startToken[0]) * 60;
            int endHour = Integer.parseInt(endToken[0]) * 60;
            int startMinute = Integer.parseInt(startToken[1]);
            int endMinute = Integer.parseInt(endToken[1]);

            this.playTime = (endHour + endMinute) - (startHour + startMinute);
        }

        void calMelody() {
            for (int i = 0; i < this.playTime; i++) {
                this.melody += this.sheet.charAt(i % (this.sheet.length()));
            }
        }
    }
    class Solution {
        public String solution(String m, String[] musicinfos) {
            String answer = "";
            int playTime = 0;

            m = m.replaceAll("C#", "c").replaceAll("A#", "a").replaceAll("G#", "g").replaceAll("F#", "f").replaceAll("D#", "d");

            for (String musicinfo : musicinfos) {
                String[] token = musicinfo.split(",");
                token[3] = token[3].replaceAll("C#", "c").replaceAll("A#", "a").replaceAll("G#", "g").replaceAll("F#", "f").replaceAll("D#", "d");

                Music music = new Music(token[0], token[1], token[2], token[3]);

                if (music.melody.contains(m)) {
                    if (music.playTime > playTime) {
                        answer = music.title;
                        playTime = music.playTime;
                    }
                }
            }

            if (playTime == 0) {
                answer = "(None)";
            }

            return answer;
        }
    }
}
