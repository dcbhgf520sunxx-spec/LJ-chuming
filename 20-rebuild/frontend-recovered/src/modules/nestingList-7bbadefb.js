import { l as e } from "../shared/runtime.js";
function r(t) {
  return e({ url: "/api/cut/getNestingList", method: "get", params: t });
}
const c = { get: r };
export {
  c
};
