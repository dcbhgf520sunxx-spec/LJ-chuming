import { l as c } from "../shared/runtime.js";
function e(t) {
  return c({ module: "contract", url: "supply-chain/logistics/summary", method: "get", params: t });
}
function i(t) {
  return c({ module: "contract", url: "supply-chain/logistics/record", method: "get", params: t });
}
function r(t) {
  return c({ module: "contract", url: "supply-chain/logistics-payment/detail", method: "get", params: t });
}
function n(t) {
  return c({ module: "contract", url: "contract/receive-invoice/logistics", method: "get", params: t });
}
const s = { get: e };
export {
  i as a,
  s as c,
  n as i,
  r as l
};
