import { zd as a } from "../../../../../../shared/runtime.js";
import { openBlock as t } from "vue";
import { createElementBlock as r } from "vue";
import { unref as o } from "vue";
import { Fragment as c } from "vue";
import { toDisplayString as s } from "vue";
import { createCommentVNode as i } from "vue";
const p = { key: 0, class: "project-ware-text" }, f = { key: 1, class: "public-ware-text" }, _ = { key: 2 }, d = { key: 1 }, y = { __name: "direction-text-info", props: { transferReceipt: { type: Object, default: () => ({}) } }, setup(n) {
  const e = n;
  return (u, m) => (t(), r("span", null, [e.transferReceipt.transferType !== o(a).RETURN_PARTY_A.V && e.transferReceipt.direction ? (t(), r(c, { key: 0 }, [e.transferReceipt.direction.project ? (t(), r("span", p, s(e.transferReceipt.direction.project), 1)) : (t(), r("span", f, "公共库")), e.transferReceipt.direction.warehouse ? (t(), r("span", _, "（" + s(e.transferReceipt.direction.warehouse.name) + "）", 1)) : i("", true)], 64)) : (t(), r("span", d, "-"))]));
} };
export {
  y as default
};
