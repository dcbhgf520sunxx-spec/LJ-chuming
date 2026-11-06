import { ref as u } from "vue";
import { computed as x } from "vue";
import { inject as L } from "vue";
import { resolveComponent as p } from "vue";
import { openBlock as f } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as v } from "vue";
import { createElementVNode as N } from "vue";
import { createVNode as l } from "vue";
import { unref as n } from "vue";
import { withDirectives as O } from "vue";
import { createCommentVNode as T } from "vue";
import { isRef as P } from "vue";
import { ElTableColumn as Q } from "element-plus";
import { vLoading as W } from "element-plus";
import { _ as $, u as J, o as S, pB as c, sQ as F, wq as G, cO as A, jl as K, r8 as X, r9 as Y, fv as Z, jG as ee, jH as ae, k5 as oe, k6 as se } from "../../../../../../shared/runtime.js";
const te = { class: "head-container", style: { display: "flex" } }, le = { __name: "inventory-drawer", props: { visible: { type: Boolean, default: false }, params: { type: Object, default: () => {
} } }, emits: ["update:visible", "use-inventory"], setup(B, { emit: U }) {
  const g = u(), R = U, b = B, { visible: h, handleClose: z } = J({ emit: R, props: b, field: "visible", showHook: M }), { maxHeight: q } = S({ extraBox: [".el-drawer__header", ".requisitions-inventory-header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, g), w = x(() => e.value.basicClass), E = { projectWarehouseType: c.PUBLIC.V, workshopId: void 0, warehouseId: void 0, projectId: void 0, basicClass: void 0 }, H = u([["project", "parse-project"]]), e = u({}), y = u(false), j = u([]), C = L("useInventoryInfo");
  F();
  function M() {
    var s;
    e.value = E, e.value.basicClass = (s = b.params) == null ? void 0 : s.basicClass, r();
  }
  async function r() {
    try {
      y.value = true;
      const { classifyId: s, specification: a } = b.params, I = { spec: a, classifyId: s, ...e.value }, { content: i } = await G(I);
      await A(i), await K(i, { toSmallest: false, toNum: true }), j.value = i.map((t) => {
        var m;
        let d = t.frozenQuantity || 0;
        return (m = C.value) != null && m[t.id] && (d += C.value[t.id]), t.canUseQuantity = t.quantity - d, t;
      });
    } catch (s) {
      console.log("获取可申购库存失败", s);
    } finally {
      y.value = false;
    }
  }
  const V = x(() => {
    var s;
    return ((s = e.value) == null ? void 0 : s.projectWarehouseType) === c.PROJECT.V;
  });
  return (s, a) => {
    const I = p("common-radio-button"), i = p("table-cell-tag"), t = Q, d = p("common-table"), m = p("common-drawer"), D = W;
    return f(), _(m, { ref_key: "drawerRef", ref: g, modelValue: n(h), "onUpdate:modelValue": a[4] || (a[4] = (o) => P(h) ? h.value = o : null), "before-close": n(z), direction: "rtl", size: "90%", title: "库存一览" }, { titleRight: v(() => a[5] || (a[5] = [])), content: v(() => [N("div", te, [l(I, { modelValue: e.value.projectWarehouseType, "onUpdate:modelValue": a[0] || (a[0] = (o) => e.value.projectWarehouseType = o), options: n(c).ENUM, class: "filter-item", size: "default", type: "enum", onChange: r }, null, 8, ["modelValue", "options"]), l(X, { modelValue: e.value.workshopId, "onUpdate:modelValue": a[1] || (a[1] = (o) => e.value.workshopId = o), class: "filter-item", clearable: "", filterable: "", size: "default", onChange: r }, null, 8, ["modelValue"]), l(Y, { modelValue: e.value.warehouseId, "onUpdate:modelValue": a[2] || (a[2] = (o) => e.value.warehouseId = o), "workshop-id": e.value.workshopId, class: "filter-item", clearable: "", filterable: "", "show-all": "", size: "default", onChange: r }, null, 8, ["modelValue", "workshop-id"]), l(Z, { modelValue: e.value.projectId, "onUpdate:modelValue": a[3] || (a[3] = (o) => e.value.projectId = o), class: "filter-item", clearable: "", filterable: "", size: "default", onChange: r }, null, 8, ["modelValue"])]), O((f(), _(d, { data: j.value, "data-format": H.value, "max-height": n(q), style: { width: "100%" } }, { default: v(() => [l(ee, { "basic-class": w.value, specMerge: "" }, { snTag: v(({ row: o }) => {
      var k;
      return [!((k = o == null ? void 0 : o.project) != null && k.id) && e.value.warehouseType === n(c).PROJECT.V ? (f(), _(i, { key: 0, offset: 15, name: "公共库" })) : T("", true)];
    }), _: 1 }, 8, ["basic-class"]), l(ae, { "basic-class": w.value }, null, 8, ["basic-class"]), l(oe, { "basic-class": w.value }, null, 8, ["basic-class"]), e.value.warehouseType === n(c).PROJECT.V ? (f(), _(t, { key: 0, align: "left", label: "项目", "min-width": "120px", prop: "project", "show-overflow-tooltip": "" })) : T("", true), l(se, { "show-area": V.value, "show-monomer": V.value, "show-project": V.value, "show-workshop": "" }, null, 8, ["show-area", "show-monomer", "show-project"])]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[D, y.value]])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, ie = $(le, [["__scopeId", "data-v-c7750439"]]);
export {
  ie as default
};
