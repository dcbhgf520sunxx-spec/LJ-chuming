import { ref as k } from "vue";
import { resolveComponent as p } from "vue";
import { openBlock as D } from "vue";
import { createBlock as T } from "vue";
import { withCtx as l } from "vue";
import { createVNode as e } from "vue";
import { createTextVNode as d } from "vue";
import { toDisplayString as V } from "vue";
import { unref as c } from "vue";
import { isRef as j } from "vue";
import { ElTag as C } from "element-plus";
import { ElTableColumn as q } from "element-plus";
import { u as z, o as I, ba as N } from "../../../shared/runtime.js";
import { b as R } from "../../../modules/project-overview-1b3937a7.js";
const O = { __name: "project-outbound-statistics-detail", props: { visible: { type: Boolean, default: false }, teamData: { type: Object, default: () => {
} }, query: { type: Object }, steelData: { type: Object, default: () => {
} }, showType: { type: String, default: "钢材" } }, emits: ["update:visible"], setup(r, { emit: f }) {
  const u = k([]), b = f, i = r, { visible: m, handleClose: y } = z({ emit: b, props: i, field: "visible", showHook: w });
  async function w() {
    var a, s;
    let t = [];
    try {
      const { content: n = [] } = await R({ monomerId: (a = i.teamData.monomer) == null ? void 0 : a.id, areaId: (s = i.teamData.area) == null ? void 0 : s.id, ...i.query, productId: i.teamData.id });
      t = n;
    } catch (n) {
      console.log("获取项目出库统计详情失败", n);
    } finally {
      u.value = t;
    }
  }
  const { maxHeight: h } = I({ paginate: true });
  function g(t) {
    return N(t, { props: ["quantity", "totalNetWeight"] });
  }
  return (t, a) => {
    const s = C, n = p("print-table"), o = q, _ = p("common-table"), x = p("common-drawer");
    return D(), T(x, { ref: "drawerRef", title: `${r.showType}出库统计`, modelValue: c(m), "onUpdate:modelValue": a[0] || (a[0] = (v) => j(m) ? m.value = v : null), direction: "rtl", "close-on-click-modal": false, "before-close": c(y), size: "60%" }, { titleAfter: l(() => [e(s, { size: "small" }, { default: l(() => a[1] || (a[1] = [d(" 项目： xxxxxxxx ")])), _: 1, __: [1] }), e(s, { type: "success", size: "small" }, { default: l(() => [d(" 物料类别： " + V(r.showType), 1)]), _: 1 })]), titleRight: l(() => [e(n, { "api-key": t.apiKey, params: { ...t.params }, size: "mini", type: "warning", class: "filter-item" }, null, 8, ["api-key", "params"])]), content: l(() => [e(_, { ref: "tableRef", data: u.value, "max-height": c(h), style: { width: "100%" }, "show-summary": "", "summary-method": g }, { default: l(() => [e(o, { "show-overflow-tooltip": true, prop: "index", label: "序号", align: "center", width: "60", type: "index" }), e(o, { "show-overflow-tooltip": true, prop: "monomerName", label: "类别", align: "center" }), e(o, { "show-overflow-tooltip": true, prop: "thickness", label: "厚度", align: "center" }), e(o, { "show-overflow-tooltip": true, prop: "specification", label: "材质", align: "center" }), e(o, { "show-overflow-tooltip": true, prop: "material", label: "单位", align: "center" }), e(o, { "show-overflow-tooltip": true, prop: "quantity", label: "出库量", align: "center" })]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} };
export {
  O as default
};
