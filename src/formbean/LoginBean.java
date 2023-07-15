package formbean;


	public class LoginBean {
		private String username;
		private String email;
		private String aadhar;
		private String pancard;
		
		public String getAadhar() {
			return aadhar;
		}
		public void setAadhar(String aadhar) {
			this.aadhar = aadhar;
		}
		public String getPancard() {
			return pancard;
		}
		public void setPancard(String pancard) {
			this.pancard = pancard;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		@Override
		public String toString() {
			return "LoginBean [username=" + username + ", email=" + email + ", aadhar=" + aadhar + ", pancard="
					+ pancard + "]";
		}
		public LoginBean() {
			super();
			// TODO Auto-generated constructor stub
		}
	
		
	}