import { l as t } from "../shared/runtime.js";
function i(e) {
  return t({ url: "/api/enterprisenetdisk/basic-info", method: "get", params: e });
}
function n(e) {
  return t({ url: "/api/user/intellectual/property", method: "get", params: e });
}
export {
  i as a,
  n as g
};
