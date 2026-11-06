import { resolveComponent as c } from "vue";
import { openBlock as _ } from "vue";
import { createElementBlock as d } from "vue";
import { createVNode as e } from "vue";
import { createElementVNode as t } from "vue";
import { withCtx as o } from "vue";
import { toDisplayString as r } from "vue";
import { unref as i } from "vue";
import { ElTableColumn as p } from "element-plus";
import { ElTable as m } from "element-plus";
import { s as b } from "../../../../../../modules/logistiics-7d598f3c.js";
import { _ as h } from "../../../../../../shared/runtime.js";
const u = { class: "second-table-container" }, f = { class: "table-box" }, g = { class: "text-color" }, v = { __name: "second-table", setup(w) {
  return (x, y) => {
    const n = c("table-header"), a = p, l = m;
    return _(), d("div", u, [e(n, { headerTitle: "物流明细及支付记录" }), t("div", f, [e(l, { border: "", data: i(b), fit: "", "show-summary": "" }, { default: o(() => [e(a, { type: "index", label: "序号", align: "center", width: "80" }), e(a, { prop: "project", label: "项目", align: "center", "min-width": "140" }), e(a, { prop: "type", label: "类型", align: "center", "min-width": "100" }), e(a, { prop: "accumulativeFee", label: "累计物流费", align: "center", "min-width": "120" }), e(a, { prop: "havePaid", label: "已支付", align: "center", "min-width": "120" }), e(a, { prop: "appliedAmount", label: "本次申请金额", align: "center", "min-width": "120" }, { default: o(({ row: s }) => [t("span", g, r(s.appliedAmount), 1)]), _: 1 })]), _: 1 }, 8, ["data"])])]);
  };
} }, E = h(v, [["__scopeId", "data-v-651d0ffb"]]);
export {
  E as default
};
