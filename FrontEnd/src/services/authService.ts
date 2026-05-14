import api from "./api";

type LoginResponse = {
  token: string;
};

export const loginUser = async (
  username: string,
  password: string
): Promise<LoginResponse> => {
  const response = await api.post("/auth/login", {
  username,
  password,
});

  return response.data
  ;
};