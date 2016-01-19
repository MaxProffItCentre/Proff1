package Minister;

public class DeputyBuilder extends Deputy{
	
	public DeputyBuilder(){}
	
	public Builder newBuilder(){
		return new DeputyBuilder().new Builder();
	}
	
	class Builder{
		
		public Builder setName(String name){
			 DeputyBuilder.this.setName(name);
			 return this;
		}
		
		public Builder setRegister(boolean set){
			 DeputyBuilder.this.setIsReg(set);
			 return this;
		}
		
		public DeputyBuilder build(){
			return DeputyBuilder.this;
		}
	}
	
	
}
