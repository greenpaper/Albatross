--the table to store users
create table users(
	username char(20) primary key,
	password char(25) NOT NULL,
	email char(20) NOT NULL,
	cellnum char(20),
	city char(20),
	state char(20)
);
--query to take a username and find the password
--insert into users values('memelord','plsgivlamp','pesado@phiota.net','8455417570','Troy', 'New York');
--
--select 
--	password
--from 
--	users 
--where
--	username = 'memelord';
--how i think itll be called in java
--public void findActorByID(String name, String password) 
--{
--        String SQL = "SELECT password "
--                + "FROM users "
--                + "WHERE username = ?";
-- 
--        try (Connection conn = connect();
--                PreparedStatement pstmt = conn.prepareStatement(SQL)) {
--
--            pstmt.setInt(1, name);
--            ResultSet rs = pstmt.executeQuery();
--            displayActor(rs);//this gives the password
--        } catch (SQLException ex) {
--            System.out.println(ex.getMessage());
--        }
--    }