class Solution {

	public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
		
		int totalLen = Integer.parseInt(video_len.split(":")[0]) * 60 + Integer.parseInt(video_len.split(":")[1]);
		int posLen = Integer.parseInt(pos.split(":")[0]) * 60 + Integer.parseInt(pos.split(":")[1]);
		int opStartLen = Integer.parseInt(op_start.split(":")[0]) * 60 + Integer.parseInt(op_start.split(":")[1]);
		int opEndLen = Integer.parseInt(op_end.split(":")[0]) * 60 + Integer.parseInt(op_end.split(":")[1]);
		
		if (opStartLen <= posLen && posLen <= opEndLen) {
			posLen = opEndLen;
		}
		
		for (String command : commands) {
			if (command.equals("next")) {
				posLen = posLen + 10 > totalLen ? totalLen : posLen + 10;
			} else {
				posLen = posLen - 10 < 0 ? 0 : posLen - 10;
			}
			if (opStartLen <= posLen && posLen <= opEndLen) {
				posLen = opEndLen;
			}
		}
		
		return String.format("%02d:%02d", posLen / 60, posLen % 60);
	}
}