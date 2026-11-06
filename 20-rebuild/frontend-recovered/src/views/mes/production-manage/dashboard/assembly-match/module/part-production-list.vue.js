import { ref as p } from "vue";
import { watch as w } from "vue";
import { resolveComponent as u } from "vue";
import { resolveDirective as v } from "vue";
import { openBlock as x } from "vue";
import { createElementBlock as g } from "vue";
import { createElementVNode as r } from "vue";
import { withDirectives as k } from "vue";
import { unref as d } from "vue";
import { createVNode as t } from "vue";
import { withCtx as n } from "vue";
import { toDisplayString as l } from "vue";
import { ElTableColumn as q } from "element-plus";
import { p as D } from "../../../../../../modules/assembly-match-4f9c2c34.js";
import { _ as M, o as N, pw as P } from "../../../../../../shared/runtime.js";
const B = { class: "app-container" }, C = { class: "head-container", style: { width: "300px", float: "right" } }, H = { __name: "part-production-list", props: { query: { type: Object } }, setup(_) {
  const c = p(), s = p([]), i = _;
  w(() => i.query.monomerId, (e) => {
    e && m();
  }, { deep: true, immediate: true });
  async function m() {
    s.value = [];
    try {
      const e = await D({ ...i.query });
      s.value = e;
    } catch (e) {
      console.log("获取区域下的零件生产数据失败", e);
    }
  }
  const { maxHeight: y } = N({ extraBox: [".head-container"], clientHRepMainH: true, navbar: false, paginate: false }, c);
  return (e, R) => {
    const f = u("print-table"), o = q, h = u("common-table"), b = v("permission");
    return x(), g("div", B, [r("div", C, [k(t(f, { "api-key": "mesMachinePartList", params: { ...i.query }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[b, d(P).printDetail]])]), t(h, { ref_key: "tableRef", ref: c, data: s.value, "empty-text": "暂无数据", "max-height": d(y) + 20, "row-key": "id", style: { width: "100%" } }, { default: n(() => [t(o, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), t(o, { align: "center", key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "零部件编号" }, { default: n((a) => [r("span", null, l(a.row.serialNumber), 1)]), _: 1 }), t(o, { align: "center", key: "quantity", prop: "quantity", "show-overflow-tooltip": true, label: "数量" }, { default: n((a) => [r("span", null, l(a.row.quantity), 1)]), _: 1 }), t(o, { align: "center", key: "producedQuantity", prop: "producedQuantity", "show-overflow-tooltip": true, label: "已生产" }, { default: n((a) => [r("span", null, l(a.row.producedQuantity), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])]);
  };
} }, I = M(H, [["__scopeId", "data-v-6349613b"]]);
export {
  I as default
};
