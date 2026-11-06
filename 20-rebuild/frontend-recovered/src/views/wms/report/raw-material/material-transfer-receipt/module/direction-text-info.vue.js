import { zd as o } from "../../../../../../shared/runtime.js";
import { openBlock as t } from "vue";
import { createElementBlock as r } from "vue";
import { unref as a } from "vue";
import { Fragment as c } from "vue";
import { toDisplayString as s } from "vue";
import { createCommentVNode as p } from "vue";
const i = { key: 0, class: "project-ware-text" }, f = { key: 1, class: "public-ware-text" }, _ = { key: 2 }, d = { key: 1 }, k = { __name: "direction-text-info", props: { transferReceipt: { type: Object, default: () => ({}) } }, setup(n) {
  const e = n;
  return (m, l) => (t(), r("span", null, [e.transferReceipt.transferType !== a(o).RETURN_PARTY_A.V && e.transferReceipt.direction ? (t(), r(c, { key: 0 }, [e.transferReceipt.direction.project ? (t(), r("span", i, s(e.transferReceipt.direction.project), 1)) : (t(), r("span", f, "公共库")), e.transferReceipt.direction.workshop ? (t(), r("span", _, "（" + s(e.transferReceipt.direction.workshop.name) + "）", 1)) : p("", true)], 64)) : (t(), r("span", d, "-"))]));
} };
export {
  k as default
};
