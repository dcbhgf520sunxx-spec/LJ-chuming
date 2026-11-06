import { inject as y } from "vue";
import { ref as i } from "vue";
import { resolveComponent as s } from "vue";
import { openBlock as E } from "vue";
import { createElementBlock as T } from "vue";
import { createElementVNode as m } from "vue";
import { createVNode as t } from "vue";
import { unref as u } from "vue";
import { withCtx as d } from "vue";
import { createTextVNode as A } from "vue";
import { mergeProps as k } from "vue";
import { Fragment as F } from "vue";
import { ElMessage as M } from "element-plus";
import { ElTableColumn as R } from "element-plus";
import { v0 as n, b as S, iX as B } from "../../../../../../../../shared/runtime.js";
const L = { class: "head-container" }, j = { style: { float: "right" } }, W = { __name: "index", emits: ["add-purchase"], setup(q, { expose: f, emit: b }) {
  var p;
  const h = b, w = (p = y("crud")) == null ? void 0 : p.form, r = i(n.STRUC_MANUFACTURED.V), c = i([]), l = i([]);
  function _(a) {
    var e;
    return S((e = w.manufListObj) == null ? void 0 : e[a.id]);
  }
  function g(a) {
    c.value = a.map((e) => (e.totalNetWeight = B(e.quantity * e.netWeight, 2), e.basicClass = n.STRUC_MANUFACTURED.V, e.curPurchaseQuantity = e.quantity, e));
  }
  function C(a) {
    l.value = a;
  }
  function v() {
    var a;
    if (!((a = l.value) != null && a.length)) {
      M.warning("请选择数据");
      return;
    }
    h("add-purchase", l.value);
  }
  return f({ initList: g }), (a, e) => {
    const x = s("common-radio-button"), N = s("common-button"), o = R, V = s("common-table");
    return E(), T(F, null, [m("div", L, [t(x, { type: "enum", modelValue: r.value, "onUpdate:modelValue": e[0] || (e[0] = (U) => r.value = U), options: u(n).ENUM, disabledVal: [u(n).ENCL_MANUFACTURED.V], clearable: "", class: "filter-item" }, null, 8, ["modelValue", "options", "disabledVal"]), m("span", j, [t(N, { type: "warning", class: "filter-item", size: "default", icon: "el-icon-plus", onClick: v }, { default: d(() => e[1] || (e[1] = [A("选择加入")])), _: 1, __: [1] })])]), t(V, k(a.$attrs, { data: c.value, "return-source-data": "", onSelectionChange: C }), { default: d(() => [t(o, { type: "selection", width: "55", align: "center", selectable: _ }), t(o, { label: "序号", type: "index", align: "center", width: "60" }), t(o, { prop: "monomer.name", label: "单体", align: "center", "show-overflow-tooltip": "", "min-width": "120px" }), t(o, { prop: "area.name", label: "区域", align: "center", "show-overflow-tooltip": "", "min-width": "120px" }), t(o, { prop: "name", label: "名称", align: "center", "show-overflow-tooltip": "", "min-width": "100px" }), t(o, { prop: "serialNumber", label: "编号", align: "center", "show-overflow-tooltip": "", "min-width": "100px" }), t(o, { prop: "specification", label: "规格", align: "center", "show-overflow-tooltip": "", "min-width": "140px" }), t(o, { prop: "length", label: "长度（mm）", align: "center", "show-overflow-tooltip": "" }), t(o, { prop: "material", label: "材质", align: "center", "show-overflow-tooltip": "" }), t(o, { prop: "quantity", label: "申购数量", align: "center", "show-overflow-tooltip": "" }), t(o, { prop: "totalNetWeight", label: "总重（kg）", align: "center", "show-overflow-tooltip": "" })]), _: 1 }, 16, ["data"])], 64);
  };
} };
export {
  W as default
};
