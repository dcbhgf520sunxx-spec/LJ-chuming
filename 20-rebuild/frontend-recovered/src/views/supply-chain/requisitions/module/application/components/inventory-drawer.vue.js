import { ref as m } from "vue";
import { inject as ie } from "vue";
import { computed as K } from "vue";
import { resolveComponent as _ } from "vue";
import { openBlock as C } from "vue";
import { createElementBlock as ue } from "vue";
import { createVNode as l } from "vue";
import { withCtx as s } from "vue";
import { unref as n } from "vue";
import { createBlock as B } from "vue";
import { createCommentVNode as S } from "vue";
import { withDirectives as re } from "vue";
import { createElementVNode as v } from "vue";
import { toDisplayString as j } from "vue";
import { isRef as ce } from "vue";
import { createTextVNode as de } from "vue";
import { Fragment as me } from "vue";
import { ElMessage as fe } from "element-plus";
import { ElFormItem as pe } from "element-plus";
import { ElForm as _e } from "element-plus";
import { ElTableColumn as ve } from "element-plus";
import { vLoading as be } from "element-plus";
import { _ as ye, u as he, o as we, pB as V, sQ as ge, wC as Ce, cO as Ve, jl as Ee, vI as q, jG as Ie, jH as Te, k5 as xe, k6 as ke, bl as L, b as Ue, i as E } from "../../../../../../shared/runtime.js";
const Be = { __name: "inventory-drawer", props: { visible: { type: Boolean, default: false }, params: { type: Object, default: () => {
} } }, emits: ["update:visible", "use-inventory"], setup(z, { emit: X }) {
  const P = m(), F = X, I = z, { visible: M, handleClose: O } = he({ emit: F, props: I, field: "visible", showHook: ae }), { maxHeight: Y } = we({ extraBox: [".el-drawer__header", ".requisitions-inventory-header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, P), Z = { warehouseType: V.PUBLIC.V }, ee = m([["project", "parse-project"]]), o = m({}), T = m(false), h = m(), r = m({}), R = m(false), A = m([]), D = ie("useInventoryInfo"), f = K(() => o.value.basicClass), { baseUnit: H } = ge();
  function ae() {
    var a;
    o.value = Z, o.value.basicClass = (a = I.params) == null ? void 0 : a.basicClass, N();
  }
  async function N() {
    try {
      R.value = true;
      const { classifyId: a, specification: e, basicClass: c, thickness: i, width: p, length: d, materialInventoryId: b, useQuantity: x } = I.params, k = { spec: e, classifyId: a, thickness: i, width: p, length: d, ...o.value };
      c !== o.value.basicClass && (k.classifyId = void 0);
      const { content: w } = await Ce(k);
      await Ve(w), await Ee(w, { toSmallest: false, toNum: true }), A.value = w.map((u) => {
        var U;
        let g = u.frozenQuantity || 0;
        return (U = D.value) != null && U[u.id] && (g += D.value[u.id]), b && b === u.id && (g -= x || 0), u.canUseQuantity = u.quantity - g, u;
      });
    } catch (a) {
      console.log("获取可申购库存失败", a);
    } finally {
      R.value = false;
    }
  }
  const Q = K(() => {
    var a;
    return ((a = o.value) == null ? void 0 : a.projectWarehouseType) === V.PROJECT.V;
  });
  function le(a) {
    r.value = a, h.value = void 0, T.value = true;
  }
  function te() {
    if (Ue(h.value)) {
      fe.warning("请选择利用数量");
      return;
    }
    F("use-inventory", h.value, r.value), T.value = false, O();
  }
  function se({ row: a, column: e, rowIndex: c, columnIndex: i }) {
    if (ne(a)) return { "background-color": "#f5ffef" };
  }
  function ne(a) {
    let e = true;
    const { classifyId: c, thickness: i, width: p, length: d } = I.params;
    return E(c) && a.classifyId !== c && (e = false), a.basicClass & L.STEEL_PLATE.V && (E(i) && a.thickness !== i && (e = false), E(p) && a.width !== p && (e = false), E(d) && a.length !== d && (e = false)), a.basicClass & L.SECTION_STEEL.V && E(d) && a.length !== d && (e = false), e;
  }
  return (a, e) => {
    const c = _("common-radio"), i = pe, p = _e, d = _("table-cell-tag"), b = ve, x = _("common-button"), k = _("common-table"), w = _("common-drawer"), u = _("common-input-number"), g = _("common-dialog"), U = be;
    return C(), ue(me, null, [l(w, { ref_key: "drawerRef", ref: P, title: "库存一览", modelValue: n(M), "onUpdate:modelValue": e[2] || (e[2] = (t) => ce(M) ? M.value = t : null), direction: "rtl", "before-close": n(O), size: "90%" }, { titleRight: s(() => e[5] || (e[5] = [])), content: s(() => [l(p, { class: "requisitions-inventory-header", style: { display: "flex" } }, { default: s(() => [l(i, { label: "库存" }, { default: s(() => [l(c, { modelValue: o.value.warehouseType, "onUpdate:modelValue": e[0] || (e[0] = (t) => o.value.warehouseType = t), options: n(V).ENUM, type: "enum", size: "default", onChange: N }, null, 8, ["modelValue", "options"])]), _: 1 }), z.params.basicClass & n(q).STEEL_PLATE.V ? (C(), B(i, { key: 0, style: { "margin-left": "80px" }, label: "种类" }, { default: s(() => [l(c, { modelValue: o.value.basicClass, "onUpdate:modelValue": e[1] || (e[1] = (t) => o.value.basicClass = t), options: n(q).ENUM, unshowVal: [n(q).SECTION_STEEL.V], type: "enum", size: "default", onChange: N }, null, 8, ["modelValue", "options", "unshowVal"])]), _: 1 })) : S("", true)]), _: 1 }), re((C(), B(k, { data: A.value, "data-format": ee.value, "cell-style": se, "max-height": n(Y), style: { width: "100%" } }, { default: s(() => [l(Ie, { "basic-class": f.value, specMerge: "" }, { snTag: s(({ row: t }) => {
      var y;
      return [!((y = t == null ? void 0 : t.project) != null && y.id) && o.value.warehouseType === n(V).PROJECT.V ? (C(), B(d, { key: 0, name: "公共库", offset: 15 })) : S("", true)];
    }), _: 1 }, 8, ["basic-class"]), l(b, { label: "可利用数量", prop: "canUseQuantity", align: "right", width: "100" }, { default: s(({ row: t }) => [v("span", null, j(t.canUseQuantity), 1)]), _: 1 }), l(Te, { "basic-class": f.value }, null, 8, ["basic-class"]), l(xe, { "basic-class": f.value }, null, 8, ["basic-class"]), o.value.warehouseType === n(V).PROJECT.V ? (C(), B(b, { key: 0, prop: "project", label: "项目", align: "left", "min-width": "120px", "show-overflow-tooltip": "" })) : S("", true), l(ke, { "show-workshop": "", "show-project": Q.value, "show-monomer": Q.value, "show-area": Q.value }, null, 8, ["show-project", "show-monomer", "show-area"]), l(b, { label: "操作", width: "70", align: "center", fixed: "right" }, { default: s(({ row: { sourceRow: t } }) => [l(x, { icon: "el-icon-plus", disabled: !t.canUseQuantity, type: "success", size: "default", onClick: (y) => le(t) }, null, 8, ["disabled", "onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[U, R.value]])]), _: 1 }, 8, ["modelValue", "before-close"]), l(g, { modelValue: T.value, "onUpdate:modelValue": e[4] || (e[4] = (t) => T.value = t), title: "选择数量", width: 460 }, { titleRight: s(() => [l(x, { size: "default", type: "primary", onClick: te }, { default: s(() => e[6] || (e[6] = [de("确定")])), _: 1, __: [6] })]), default: s(() => [e[7] || (e[7] = v("div", { class: "tip" }, [v("span", null, "* 提示："), v("span", null, " 若选择此材料，对应物料库存在申购提交之后将被冻结！")], -1)), l(p, { "label-width": "110px" }, { default: s(() => {
      var t, y, $;
      return [l(i, { label: "物料种类" }, { default: s(() => [v("span", null, j(r.value.classifyName), 1)]), _: 1 }), l(i, { label: "规格" }, { default: s(() => [v("span", null, j(r.value.specMerge), 1)]), _: 1 }), l(i, { label: "可利用数量" }, { default: s(() => [v("span", null, j(r.value.canUseQuantity), 1)]), _: 1 }), l(i, { label: `利用数量(${f.value & n(L).MATERIAL.V ? (t = r.value) == null ? void 0 : t.outboundUnit : ($ = (y = n(H)[f.value]) == null ? void 0 : y.measure) == null ? void 0 : $.unit})`, required: "" }, { default: s(() => {
        var J, G, W;
        return [l(u, { modelValue: h.value, "onUpdate:modelValue": e[3] || (e[3] = (oe) => h.value = oe), min: 1, max: r.value.canUseQuantity, "controls-position": "right", controls: false, step: 1, precision: f.value & n(L).MATERIAL.V ? (J = r.value) == null ? void 0 : J.outboundUnitPrecision : (W = (G = n(H)[f.value]) == null ? void 0 : G.measure) == null ? void 0 : W.precision, size: "default", placeholder: "数量" }, null, 8, ["modelValue", "max", "precision"])];
      }), _: 1 }, 8, ["label"])];
    }), _: 1 })]), _: 1, __: [7] }, 8, ["modelValue"])], 64);
  };
} }, Me = ye(Be, [["__scopeId", "data-v-1b48eefa"]]);
export {
  Me as default
};
