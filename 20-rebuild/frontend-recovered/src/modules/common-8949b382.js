import { l as e } from "../shared/runtime.js";
function s(r) {
  return e({ module: "bridge", url: "task/order", method: "post", data: r });
}
export {
  s
};
