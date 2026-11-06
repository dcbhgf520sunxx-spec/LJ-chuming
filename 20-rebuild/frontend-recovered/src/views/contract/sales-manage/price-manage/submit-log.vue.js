import { ref as u } from "vue";
import { watch as ae } from "vue";
import { computed as ne } from "vue";
import { resolveComponent as N } from "vue";
import { resolveDirective as le } from "vue";
import { openBlock as d } from "vue";
import { createBlock as b } from "vue";
import { withCtx as s } from "vue";
import { createVNode as o } from "vue";
import { createTextVNode as O } from "vue";
import { unref as a } from "vue";
import { withDirectives as M } from "vue";
import { createElementBlock as U } from "vue";
import { Fragment as j } from "vue";
import { createCommentVNode as m } from "vue";
import { createElementVNode as f } from "vue";
import { toDisplayString as I } from "vue";
import { withModifiers as re } from "vue";
import { isRef as ie } from "vue";
import { ElMessage as X } from "element-plus";
import { ElTableColumn as se } from "element-plus";
import { ElPagination as ce } from "element-plus";
import { vLoading as pe } from "element-plus";
import { g as de, f as ue } from "../../../../modules/common-913d415d.js";
import { _ as me, t as ye, u as ge, J as fe, kz as i, o as he, kC as we, c as be, D as x, bT as Y, iB as Ie, T as k, ky as _e, bV as ve } from "../../../../shared/runtime.js";
import { _ as Te } from "./preview.vue.js";
import "../../../../modules/index-61ce89a1.js";
const Pe = { style: { color: "red" } }, ke = { style: { color: "red" } }, Ee = { style: { color: "red" } }, Ve = { __name: "submit-log", props: { modelValue: { type: Boolean, require: true }, areaId: { type: [Number, String], default: void 0 }, category: { type: [Number, String], default: void 0 }, enclosurePlanId: { type: [Number, String], default: void 0 }, monomerId: { type: [Number, String], default: void 0 }, projectId: { type: [Number, String], default: void 0 }, projectType: { type: [Number, String], default: void 0 }, type: { type: [Number, String], default: void 0 }, relationType: { type: [Number, String], default: void 0 } }, emits: ["success", "refreshCount", "update:modelValue"], setup(h, { emit: G }) {
  const e = h, { decimalPrecision: T } = ye(), E = u(false), V = u([]), q = u(), C = u(false), R = u(false), w = u([]), A = u([]), L = G, { visible: _, handleClose: F } = ge({ emit: L, props: e }), { handleSizeChange: Q, handleCurrentChange: $, total: J, setTotalPage: K, queryPage: y } = fe({ fetchHook: P });
  ae(() => _.value, (c) => {
    c && (w.value = [], A.value = [], P());
  }, { deep: true, immediate: true });
  const H = u(), Z = ne(() => {
    switch (e.type) {
      case i.STRUCTURE.V:
      case i.MACHINE_PART.V:
        return { monomerId: e.monomerId, areaId: e.areaId, type: e.type };
      case i.ENCLOSURE.V:
        return { enclosurePlanId: e.enclosurePlanId, type: e.type };
      case i.AUXILIARY_MATERIAL.V:
        return { category: e.category, enclosurePlanId: e.enclosurePlanId, relationType: e.relationType, areaId: e.areaId, monomerId: e.monomerId, type: e.type };
      default:
        return {};
    }
  }), { maxHeight: ee } = he({ mainBox: ".log-form", extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", paginate: false, minHeight: 300, navbar: false, clientHRepMainH: true }, H);
  async function z(c) {
    if (!c.length) {
      X.error("请先选择明细");
      return;
    }
    try {
      C.value = true, await ue(c), X.success("删除成功"), P(), B(), L("success");
    } catch (l) {
      console.log("价格暂存记录删除", l);
    } finally {
      C.value = false;
    }
  }
  function B() {
    P(), L("refreshCount");
  }
  function te(c) {
    w.value = c, A.value = w.value.map((l) => l.id);
  }
  async function P() {
    const c = [];
    if (!e.projectId || !e.type) {
      V.value = c;
      return;
    }
    E.value = true;
    try {
      let l = {};
      switch (e.type) {
        case i.MACHINE_PART.V:
          l = { areaId: e.areaId, monomerId: e.monomerId, projectId: e.projectId, projectType: e.projectType, type: e.type, ...y };
          break;
        case i.ENCLOSURE.V:
          l = { category: e.category, enclosurePlanId: e.enclosurePlanId, projectId: e.projectId, projectType: e.projectType, type: e.type, ...y };
          break;
        case i.AUXILIARY_MATERIAL.V:
          l = e.relationType === we.STRUCTURE.V ? { areaId: e.areaId, monomerId: e.monomerId, projectId: e.projectId, projectType: e.projectType, relationType: e.relationType, type: e.type, ...y } : { category: e.category, enclosurePlanId: e.enclosurePlanId, projectId: e.projectId, projectType: e.projectType, relationType: e.relationType, type: e.type, ...y };
          break;
        default:
          l = { areaId: e.areaId, monomerId: e.monomerId, projectId: e.projectId, projectType: e.projectType, type: e.type, ...y };
          break;
      }
      const { content: v = [], totalElements: t } = await de(l);
      v.map((g) => {
        let p = {};
        switch (e.type) {
          case i.MACHINE_PART.V:
            p = g.machinePart;
            break;
          case i.ENCLOSURE.V:
            p = g.enclosure;
            break;
          case i.AUXILIARY_MATERIAL.V:
            p = g.standardPart;
            break;
          default:
            p = g.artifact;
            break;
        }
        e.type !== i.AUXILIARY_MATERIAL.V && (p.originPricingManner = p.pricingManner), p.originUnitPrice = p.unitPrice;
        const r = { ...p, ...g };
        e.type === i.MACHINE_PART.V || e.type === i.STRUCTURE.V ? (r.totalWeight = be(r.totalWeight, "kg", "t", x.COM_WT__T), r.totalPrice = (r.pricingManner === Y.WEIGHT.V ? r.totalWeight : r.totalLength) * (r.unitPrice && typeof r.unitPrice == "number" ? r.unitPrice : 0)) : e.type === i.ENCLOSURE.V ? r.totalPrice = (r.pricingManner === Ie.LENGTH.V ? r.totalLength : r.totalArea) * (r.unitPrice && typeof r.unitPrice == "number" ? r.unitPrice : 0) : r.totalPrice = r.mete * (r.unitPrice && typeof r.unitPrice == "number" ? r.unitPrice : 0), c.push(r);
      }), K(t);
    } catch (l) {
      console.log("价格暂存记录", l);
    } finally {
      V.value = c, E.value = false;
    }
  }
  return (c, l) => {
    const v = N("common-button"), t = se, g = N("common-table"), p = ce, r = N("common-drawer"), oe = le("thousand"), W = pe;
    return d(), b(r, { "append-to-body": "", ref_key: "drawerRef", ref: H, modelValue: a(_), "onUpdate:modelValue": l[3] || (l[3] = (n) => ie(_) ? _.value = n : null), top: "10vh", width: "600px", "before-close": a(F), title: "保存记录", "wrapper-closable": false, size: "80%", "custom-class": "log-form" }, { titleRight: s(() => [o(v, { type: "primary", size: "default", disabled: w.value.length === 0, onClick: l[0] || (l[0] = (n) => R.value = true) }, { default: s(() => l[4] || (l[4] = [O("确认提交")])), _: 1, __: [4] }, 8, ["disabled"]), o(v, { type: "danger", size: "default", disabled: w.value.length === 0, onClick: l[1] || (l[1] = (n) => z(A.value)) }, { default: s(() => l[5] || (l[5] = [O("清空")])), _: 1, __: [5] }, 8, ["disabled"])]), content: s(() => [a(_) ? M((d(), b(g, { key: 0, ref_key: "detailRef", ref: q, border: "", data: V.value, "max-height": a(ee) - 120, style: { width: "100%" }, class: "table-form", onSelectionChange: te }, { default: s(() => [o(t, { type: "selection", width: "55", align: "center" }), h.type === a(i).STRUCTURE.V || h.type === a(i).MACHINE_PART.V ? (d(), U(j, { key: 0 }, [o(t, { key: "name", prop: "name", "show-overflow-tooltip": "", label: "名称", align: "center", "min-width": "140" }), o(t, { key: "specification", prop: "specification", "show-overflow-tooltip": "", label: "规格", align: "center", "min-width": "140" }), o(t, { key: "material", prop: "material", "show-overflow-tooltip": "", label: "材质", align: "center", "min-width": "120" }), o(t, { key: "totalQuantity", prop: "totalQuantity", label: "数量", align: "center", "min-width": "70", "show-overflow-tooltip": "" }), o(t, { key: "totalLength", prop: "totalLength", label: "总长度(米)", align: "center", "min-width": "70", "show-overflow-tooltip": "" }), o(t, { key: "totalWeight", prop: "totalWeight", "show-overflow-tooltip": "", label: "总量(t)", align: "center", "min-width": "120" })], 64)) : m("", true), h.type === a(i).ENCLOSURE.V ? (d(), U(j, { key: 1 }, [o(t, { key: "name", prop: "name", "show-overflow-tooltip": "", label: "名称", align: "center", "min-width": "120" }), e.category !== a(k).BENDING.V ? (d(), b(t, { key: "plate", prop: "plate", "show-overflow-tooltip": "", label: "板型", align: "center", width: "100" })) : m("", true), o(t, { key: "thickness", prop: "thickness", "show-overflow-tooltip": "", label: "厚度(mm)", align: "center" }, { default: s(({ row: n }) => [f("span", null, I(n.thickness ? n.thickness.toFixed(a(x).MES_ENCLOSURE_T__MM) : ""), 1)]), _: 1 }), e.category === a(k).BENDING.V ? (d(), b(t, { key: "unfoldedWidth", prop: "unfoldedWidth", "show-overflow-tooltip": "", label: "展开宽度(mm)", align: "center" }, { default: s(({ row: n }) => [f("span", null, I(n.unfoldedWidth ? n.unfoldedWidth.toFixed(a(x).MES_ENCLOSURE_W__MM) : ""), 1)]), _: 1 })) : m("", true), e.category === a(k).BENDING.V ? (d(), b(t, { key: "bendTimes", prop: "bendTimes", "show-overflow-tooltip": "", label: "折弯次数", align: "center" })) : m("", true), o(t, { key: "brand", prop: "brand", "show-overflow-tooltip": "", label: "品牌", align: "center" }), o(t, { key: "color", prop: "color", "show-overflow-tooltip": "", label: "颜色", align: "center", width: "100" }), o(t, { key: "totalQuantity", prop: "totalQuantity", "show-overflow-tooltip": true, label: "数量(张)", align: "center", width: "100" }), o(t, { key: "totalArea", prop: "totalArea", "show-overflow-tooltip": "", label: "总面积(㎡)", align: "center" }), o(t, { key: "totalLength", prop: "totalLength", "show-overflow-tooltip": "", label: "总长度(m)", align: "center" }), o(t, { key: "category", prop: "category", "show-overflow-tooltip": "", label: "类别", align: "center" }, { default: s(({ row: n }) => {
      var S, D;
      return [f("span", null, I((D = (S = a(k).V) == null ? void 0 : S[n.category]) == null ? void 0 : D.L), 1)];
    }), _: 1 })], 64)) : m("", true), h.type === a(i).AUXILIARY_MATERIAL.V ? (d(), U(j, { key: 2 }, [o(t, { prop: "useProperty", label: "使用类别", align: "center" }, { default: s(({ row: n }) => [f("span", null, I(n.useProperty ? a(_e).VL[n.useProperty] : "-"), 1)]), _: 1 }), o(t, { prop: "name", label: "名称", align: "center", "show-overflow-tooltip": "" }), o(t, { "show-overflow-tooltip": "", prop: "specification", label: "规格", align: "center", "min-width": "120" }), o(t, { "show-overflow-tooltip": "", prop: "measureUnit", label: "单位", align: "center" }), o(t, { "show-overflow-tooltip": "", prop: "quantity", label: "数量", align: "center" }), o(t, { prop: "accountingUnit", "show-overflow-tooltip": "", label: "核算单位", align: "center", "min-width": "100" }), o(t, { prop: "mete", "show-overflow-tooltip": "", label: "核算量", align: "center", "min-width": "100" })], 64)) : m("", true), h.type !== a(i).AUXILIARY_MATERIAL.V ? (d(), b(t, { key: "pricingManner", prop: "pricingManner", "show-overflow-tooltip": "", label: "计价方式", align: "center", "min-width": "120" }, { default: s(({ row: n }) => [f("span", Pe, I(a(Y).VL[n.pricingManner]), 1)]), _: 1 })) : m("", true), o(t, { key: "unitPrice", prop: "unitPrice", "show-overflow-tooltip": "", label: "综合单价", align: "center", "min-width": "120" }, { default: s(({ row: n }) => [f("span", ke, I(n.unitPrice !== "同上" ? a(ve)(n.unitPrice, a(T).contract === 2 ? 3 : a(T).contract) : "-"), 1)]), _: 1 }), o(t, { key: "totalPrice", prop: "totalPrice", align: "center", "min-width": "120", label: "金额" }, { default: s(({ row: n }) => [M(f("span", Ee, null, 512), [[oe, { val: n.totalPrice || 0, dp: a(T).contract === 2 ? 3 : a(T).contract }]])]), _: 1 }), o(t, { label: "操作", width: "100px", align: "center", fixed: "right" }, { default: s(({ row: n }) => [M(o(v, { icon: "el-icon-delete", type: "danger", size: "default", onClick: re((S) => z([n.id]), ["stop"]) }, null, 8, ["onClick"]), [[W, C.value]])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[W, E.value]]) : m("", true), o(p, { total: a(J), "current-page": a(y).pageNumber, "page-size": a(y).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: a(Q), onCurrentChange: a($) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"]), o(a(Te), { modelValue: R.value, "onUpdate:modelValue": l[2] || (l[2] = (n) => R.value = n), "modified-data": w.value, params: Z.value, onSuccess: B, showType: "log" }, null, 8, ["modelValue", "modified-data", "params"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Ne = me(Ve, [["__scopeId", "data-v-3b7b7983"]]);
export {
  Ne as default
};
