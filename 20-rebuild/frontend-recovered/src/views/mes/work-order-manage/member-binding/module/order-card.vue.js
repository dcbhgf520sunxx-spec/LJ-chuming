import { ref as s } from "vue";
import { watch as z } from "vue";
import { resolveComponent as p } from "vue";
import { openBlock as B } from "vue";
import { createElementBlock as H } from "vue";
import { createVNode as l } from "vue";
import { withCtx as d } from "vue";
import { createElementVNode as v } from "vue";
import { unref as _ } from "vue";
import { withKeys as L } from "vue";
import { createTextVNode as y } from "vue";
import { normalizeStyle as O } from "vue";
import { ElInput as R } from "element-plus";
import { ElTableColumn as U } from "element-plus";
import { ElCard as q } from "element-plus";
import { m as A, q as G } from "../../../../../shared/runtime.js";
import { a as K } from "../../../../../modules/member-binding-2f5cdd6e.js";
const P = { class: "order-card-heade" }, T = { style: { "margin-bottom": "10px" } }, F = { __name: "order-card", props: { maxHeight: { type: Number, default: 500 } }, emits: ["orderRowClick"], setup(x, { emit: h }) {
  const f = x, { globalProjectId: m } = A(["globalProjectId"]), w = h, u = s([]), n = s(), r = s(), i = s([]), o = s();
  z(() => m.value, () => {
    u.value = [], i.value = [], o.value = void 0, r.value = void 0;
  });
  const V = async () => {
    try {
      const t = await K({ projectId: m.value, monomerId: n.value, areaId: r.value, serialNumber: o.value });
      console.log(t), u.value = t;
    } catch (t) {
      console.log(t, "获取工单失败");
    }
  }, I = (t) => {
    i.value = t;
  }, g = () => {
    V();
  }, C = () => {
    n.value = void 0, i.value = void 0, o.value = void 0, u.value = [];
  }, k = (t) => {
    console.log(t), w("orderRowClick", t);
  };
  return (t, e) => {
    const N = p("common-select"), j = R, b = p("common-button"), c = U, E = p("common-table"), S = q;
    return B(), H("div", null, [l(S, { style: O({ width: "500px", height: f.maxHeight + "px" }) }, { header: d(() => [v("div", P, [v("div", T, [l(_(G), { "project-id": _(m), style: { "margin-right": "8px" }, modelValue: n.value, "onUpdate:modelValue": e[0] || (e[0] = (a) => n.value = a), default: false, onGetAreaInfo: I }, null, 8, ["project-id", "modelValue"]), l(N, { style: { "margin-right": "8px" }, modelValue: r.value, "onUpdate:modelValue": e[1] || (e[1] = (a) => r.value = a), options: i.value, type: "other", dataStructure: { key: "id", label: "name", value: "id" }, placeholder: "请选择区域" }, null, 8, ["modelValue", "options"])]), v("div", null, [l(j, { style: { width: "170px", "margin-right": "5px" }, class: "filter-item", placeholder: "请输入编号搜索", modelValue: o.value, "onUpdate:modelValue": e[2] || (e[2] = (a) => o.value = a), onKeyup: e[3] || (e[3] = L((a) => g(), ["enter"])) }, null, 8, ["modelValue"]), l(b, { type: "success", size: "default", disabled: !n.value || !r.value || !o.value, onClick: g }, { default: d(() => e[5] || (e[5] = [y(" 搜索 ")])), _: 1, __: [5] }, 8, ["disabled"]), l(b, { type: "warning", size: "default", disabled: !n.value || !r.value || !o.value, onClick: C }, { default: d(() => e[6] || (e[6] = [y(" 重置 ")])), _: 1, __: [6] }, 8, ["disabled"])])])]), default: d(() => [l(E, { data: u.value, onRowClick: e[4] || (e[4] = (a) => k(a)), "max-height": f.maxHeight - 151 }, { default: d(() => [l(c, { label: "序号", align: "center", width: "80", type: "index" }), l(c, { label: "工单编号", align: "center", prop: "orderNumber" }), l(c, { label: "数量", align: "center", width: "100", prop: "quantity" })]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 8, ["style"])]);
  };
} };
export {
  F as default
};
