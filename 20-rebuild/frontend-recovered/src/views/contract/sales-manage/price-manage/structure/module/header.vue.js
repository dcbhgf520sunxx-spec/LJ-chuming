import { inject as _ } from "vue";
import { watch as W } from "vue";
import { nextTick as w } from "vue";
import { computed as re } from "vue";
import { ref as k } from "vue";
import { resolveComponent as K } from "vue";
import { resolveDirective as L } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as u } from "vue";
import { withDirectives as E } from "vue";
import { vShow as le } from "vue";
import { unref as t } from "vue";
import { createElementVNode as de } from "vue";
import { createVNode as i } from "vue";
import { withKeys as C } from "vue";
import { createSlots as ue } from "vue";
import { withCtx as s } from "vue";
import { createTextVNode as c } from "vue";
import { createBlock as y } from "vue";
import { createCommentVNode as v } from "vue";
import { toDisplayString as Q } from "vue";
import { mergeProps as ce } from "vue";
import { ElInput as me } from "element-plus";
import { ElBadge as pe } from "element-plus";
import { Loading as fe } from "@element-plus/icons-vue";
import { ElIcon as _e } from "element-plus";
import { ElTag as ye } from "element-plus";
import { a as ge } from "../../../../../../modules/structure-70e27af9.js";
import { _ as ke, t as Ie, kz as be, B as he, c as q, D as A, i as Ve, bT as R, G as I, C as Pe, kB as we, E as Ee } from "../../../../../../shared/runtime.js";
import { _ as Ce } from "../../preview.vue.js";
import "../../../../../../modules/common-913d415d.js";
import "../../../../../../modules/index-61ce89a1.js";
const ve = { class: "head-container" }, Me = { key: 0, style: { "margin-right": "6px" } }, Te = { key: 0 }, xe = { key: 0 }, ze = { key: 0 }, Se = { key: 0 }, Ue = { key: 0 }, Be = { __name: "header", props: { showAble: { type: Boolean, default: false }, submitList: { type: Array, default: () => [] }, rowIds: { type: Array, default: () => [] } }, emits: ["checkSubmit", "showVisible"], setup(M, { expose: j, emit: H }) {
  const { decimalPrecision: N } = Ie(), T = _("projectId"), O = _("monomerId"), $ = _("areaId"), x = _("saveCount"), G = _("priceEditMode"), z = H, S = M;
  W(O, (r) => {
    w(() => {
      a.query.monomerId = r, B(), a.toQuery();
    });
  }, { immediate: true }), W($, (r) => {
    w(() => {
      a.query.areaId = r, B(), a.toQuery();
    });
  }, { immediate: true });
  const F = re(() => ({ monomerId: o.monomerId, areaId: o.areaId, type: be.STRUCTURE.V })), g = k(false), p = k(false), b = k(false), U = { mete: 0, price: 0, quantity: 0 }, f = k({ ...U }), J = { name: void 0, material: void 0, specification: void 0, ids: [], monomerId: { value: void 0, resetAble: false } }, { crud: a, query: o, CRUD: X } = he(J);
  X.HOOK.handleRefresh = (r, { data: n }) => {
    n.content.forEach((e, m) => {
      e.totalWeight = q(e.totalWeight, "kg", "t", A.COM_WT__T), e.pricingManner = Ve(e.pricingManner) ? e.pricingManner : -1, e.unitPrice = e.unitPrice || "同上", e.originUnitPrice = e.unitPrice, e.totalPrice = (e.pricingManner === R.WEIGHT.V ? e.totalWeight : e.totalLength) * (e.unitPrice && typeof e.unitPrice == "number" ? e.unitPrice : 0), e.originPricingManner = e.pricingManner, e.orderIndex = m + 1;
    }), Y();
  };
  async function Y() {
    if (!(!I(a.permission.cost) || !T.value)) {
      p.value = true;
      try {
        const r = await ge({ monomerId: o.monomerId, projectId: T.value, areaId: o.areaId });
        f.value = r;
      } catch (r) {
        console.log("获取商务构件成本失败", r);
      } finally {
        p.value = false;
      }
    }
  }
  function B() {
    f.value = { ...U };
  }
  function D(r, n = false) {
    n && a.data.forEach((e) => {
      e.unitPrice = e.originUnitPrice, e.pricingManner = e.originPricingManner, e.totalPrice = (e.pricingManner === R.WEIGHT.V ? e.totalWeight : e.totalLength) * (e.unitPrice && typeof e.unitPrice == "number" ? e.unitPrice : 0);
    }), g.value = r;
  }
  function Z() {
    z("checkSubmit"), w(() => {
      b.value = S.showAble;
    });
  }
  function ee() {
    g.value = false, a.toQuery();
  }
  function te() {
    z("showVisible");
  }
  return j({ modifying: g }), (r, n) => {
    const e = me, m = K("common-button"), ne = K("print-table"), ae = pe, h = fe, V = _e, P = ye, ie = L("permission"), oe = L("thousand");
    return l(), u("div", ve, [E(de("div", null, [i(e, { modelValue: t(o).name, "onUpdate:modelValue": n[0] || (n[0] = (d) => t(o).name = d), placeholder: "可输入名称搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: C(t(a).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), i(e, { modelValue: t(o).material, "onUpdate:modelValue": n[1] || (n[1] = (d) => t(o).material = d), placeholder: "输入材质搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: C(t(a).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), i(e, { modelValue: t(o).specification, "onUpdate:modelValue": n[2] || (n[2] = (d) => t(o).specification = d), placeholder: "输入规格搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: C(t(a).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), i(t(Pe))], 512), [[le, t(a).searchToggle]]), i(t(Ee), null, ue({ viewLeft: s(() => [t(I)(t(a).permission.cost) && t(o).monomerId ? (l(), u("span", xe, [i(P, { effect: "plain", type: "success", size: "large", class: "filter-item" }, { default: s(() => [n[10] || (n[10] = c(" 结构总量(t)： ")), p.value ? (l(), y(V, { key: 1 }, { default: s(() => [i(h)]), _: 1 })) : (l(), u("span", ze, Q(t(q)(f.value.mete, "kg", "t", t(A).COM_WT__T)), 1))]), _: 1, __: [10] }), i(P, { effect: "plain", type: "success", size: "large", class: "filter-item" }, { default: s(() => [n[11] || (n[11] = c(" 结构总数(件)： ")), p.value ? (l(), y(V, { key: 1 }, { default: s(() => [i(h)]), _: 1 })) : (l(), u("span", Se, Q(f.value.quantity), 1))]), _: 1, __: [11] }), i(P, { effect: "plain", type: "success", size: "large", class: "filter-item" }, { default: s(() => [n[12] || (n[12] = c(" 结构造价(元)： ")), p.value ? (l(), y(V, { key: 1 }, { default: s(() => [i(h)]), _: 1 })) : E((l(), u("span", Ue, null, 512)), [[oe, { val: f.value.price || 0, dp: t(N).contract }]])]), _: 1, __: [12] })])) : v("", true)]), _: 2 }, [t(o).monomerId ? { name: "optRight", fn: s(() => {
      var d;
      return [t(I)(t(a).permission.save) ? (l(), u("span", Me, [g.value ? (l(), u("span", Te, [i(m, { type: "warning", size: "default", onClick: n[3] || (n[3] = (se) => D(false, true)) }, { default: s(() => n[6] || (n[6] = [c("取消录入")])), _: 1, __: [6] }), i(m, { type: "success", size: "default", onClick: Z }, { default: s(() => n[7] || (n[7] = [c("预览并保存")])), _: 1, __: [7] })])) : (l(), y(m, { key: 1, type: "primary", size: "default", onClick: n[4] || (n[4] = (se) => D(true)), disabled: ((d = t(a).selections) == null ? void 0 : d.length) === 0 }, { default: s(() => n[8] || (n[8] = [c("录入价格")])), _: 1, __: [8] }, 8, ["disabled"]))])) : v("", true), E(i(ne, { "api-key": "contractStructurePrice", params: { ...t(o), ids: S.rowIds }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[ie, t(a).permission.print]]), t(I)(t(a).permission.log) && t(G) === t(we).SAVE.V ? (l(), y(ae, { key: 1, value: t(x), hidden: t(x) <= 0 }, { default: s(() => [i(m, { type: "success", size: "default", onClick: te }, { default: s(() => n[9] || (n[9] = [c("保存记录")])), _: 1, __: [9] })]), _: 1 }, 8, ["value", "hidden"])) : v("", true)];
    }), key: "0" } : void 0]), 1024), i(t(Ce), ce({ modelValue: b.value, "onUpdate:modelValue": n[5] || (n[5] = (d) => b.value = d), "modified-data": M.submitList }, r.$attrs, { params: F.value, onSuccess: ee }), null, 16, ["modelValue", "modified-data", "params"])]);
  };
} }, Ae = ke(Be, [["__scopeId", "data-v-5ba72f8d"]]);
export {
  Ae as default
};
