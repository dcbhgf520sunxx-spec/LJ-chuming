import { ref as p } from "vue";
import { computed as Z } from "vue";
import { watch as ee } from "vue";
import { cloneDeep as te } from "lodash";
import { resolveComponent as S } from "vue";
import { resolveDirective as C } from "vue";
import { openBlock as k } from "vue";
import { createElementBlock as A } from "vue";
import { createVNode as c } from "vue";
import { withCtx as u } from "vue";
import { createTextVNode as m } from "vue";
import { withDirectives as T } from "vue";
import { createElementVNode as n } from "vue";
import { unref as i } from "vue";
import { Fragment as R } from "vue";
import { createCommentVNode as x } from "vue";
import { createBlock as ae } from "vue";
import { normalizeStyle as se } from "vue";
import { mergeProps as oe } from "vue";
import { ElTag as ie } from "element-plus";
import { ElCheckbox as le } from "element-plus";
import { ElForm as ne } from "element-plus";
import { ElInput as re } from "element-plus";
import { sG as ce, i as O, jl as N, _ as ue, ao as de, o as pe, a9 as me, aI as fe, sD as P, cO as ye, cV as _e, jN as K } from "../../../../../../shared/runtime.js";
import he from "./list-and-match/index.vue.js";
import ve from "./inventory-table.vue.js";
import ge from "./purchase-table.vue.js";
import Te from "./purchase-material-add/dialog.vue.js";
import "./list-and-match/tech-list/structure.vue.js";
import "./list-and-match/tech-list/enclosure.vue.js";
import "./list-and-match/tech-list/aux-material.vue.js";
import "./list-and-match/match-table.vue.js";
import "../../../../../../modules/factory-select-b8d0a4ac.js";
import "./list-and-match/tech-add-form.vue.js";
import "../../../../../../modules/use-table-operate-4f84437f.js";
import "./purchase-material-add/form/steel-plate.vue.js";
import "../../../../../../modules/use-purchase-material-form-info-d099f05d.js";
import "./purchase-material-add/form/section-steel.vue.js";
import "./purchase-material-add/form/aux-material.vue.js";
const be = async (d) => {
  const r = { id: d.id };
  return d.withoutList && (Array.isArray(d.technologyList) ? r.technologyList = d.technologyList.map((a) => ({ id: a.operateType === ce.ADD.V ? void 0 : a.id, operateType: a.operateType, steelClassifyConfId: a.steelClassifyConfId, listMete: a.listMete, material: a.material, specification: a.specification, basicClass: a.basicClass, steelClassifyConfName: a.steelClassifyConfName })) : r.technologyList = void 0), O(d.inventoryList) && (r.inventoryList = d.inventoryList.map((a) => {
    const { material: t } = a;
    return { id: a.boolAdd ? void 0 : a.id, remark: a.remark, material: { id: t.id, classifyId: t.classifyId, basicClass: t.basicClass, usedQuantity: t.usedQuantity, usedMete: t.usedMete, accountingUnit: t.accountingUnit, accountingPrecision: t.accountingPrecision, measureUnit: t.measureUnit, measurePrecision: t.measurePrecision, brand: t.brand } };
  }), await N(r.inventoryList, { prefix: "material", toNum: true, toSmallest: true }, { mete: ["usedMete"], quantity: ["usedQuantity"] })), O(d.purchaseList) && (r.purchaseList = d.purchaseList.map((a) => {
    const { material: t } = a;
    return { id: a.boolAdd ? void 0 : a.id, remark: a.remark, material: { classifyId: t.classifyId, basicClass: t.basicClass, accountingUnit: t.accountingUnit, accountingPrecision: t.accountingPrecision, measureUnit: t.measureUnit, measurePrecision: t.measurePrecision, brand: t.brand, serialNumber: t.serialNumber, specKV: t.specKV, specNameKV: t.specNameKV, specification: t.specification, theoryThickness: t.theoryThickness, thickness: t.thickness, width: t.width, length: t.length, mete: t.mete, quantity: t.quantity } };
  }), await N(r.purchaseList, { prefix: "material", toNum: true, toSmallest: true })), r;
};
const Le = { class: "main-content" }, Ve = { class: "head" }, we = { class: "middle" }, Ie = { class: "middle-head filter-container" }, Se = { class: "filter-left-box" }, Ce = { class: "filter-item" }, ke = { class: "filter-right-box" }, Ne = { class: "preparation-info flex-rss" }, Ee = { class: "preparation-table-list" }, Ue = { class: "table-wrapper" }, Me = { __name: "index", setup(d) {
  const r = { INVENTORY_LIST: { L: "库存利用清单", K: "INVENTORY_LIST", V: 1 }, PURCHASE_LIST: { L: "需要采购清单", K: "PURCHASE_LIST", V: 2 } }, a = p(r.INVENTORY_LIST.V), t = p("备料"), b = p(""), y = p(), E = p(), v = p(), g = p(), L = p(false), { CRUD: _, crud: o, form: V } = de(void 0, E), U = Z(() => o.status.cu > _.STATUS.NORMAL), h = p({ showOnlySelectTechInfo: false }), { maxHeight: M, heightStyle: B } = pe({ mainBox: ".project-preparation-form", extraBox: [".el-drawer__header", ".head", ".middle-head"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, U);
  ee(() => o.form.technologyList, (s) => {
    s && s.length > 0 && s[0].id ? o.props.technologyListKV = me(s) : o.props.technologyListKV = {};
  }, { immediate: true }), _.HOOK.beforeEditDetailLoaded = async (s, e) => {
    await H(s, e);
  }, _.HOOK.beforeToEdit = (s, e) => {
    D();
    let l = "";
    e.project && e.project.shortName && (l += e.project.shortName), e.monomer && e.monomer.name && (l = `${l} / ${e.monomer.name}`), e.area && e.area.name && (l = `${l} / ${e.area.name}`), t.value = `备料：${e.serialNumber}（${l}）`, b.value = e.listUploaderNames;
  }, _.HOOK.beforeValidateCU = (s, e) => v.value.validate() ? g.value.validate() : false, o.submitFormFormat = async (s) => await be(s);
  function D() {
    t.value = "备料", y.value = void 0, b.value = "", a.value = r.INVENTORY_LIST.V, h.value = { showOnlySelectTechInfo: false }, o.props.boolTechEditMode = false, o.props.technologyListKV = {}, o.props.techPrepMeteKV = {}, o.props.listTotalMete = 0, o.props.inventoryTotalMete = 0, o.props.purchaseTotalMete = 0;
  }
  async function H(s, e) {
    e.technologyList = e.technologyList || [], e.sourceTechnologyList = te(e.technologyList), e.technologyList.forEach((l) => {
      l.id = l.id || fe(), l.boundInvIds = [], l.boundPurIds = [], e.technologyListType !== P.AUXILIARY_MATERIAL.V && (s.props.listTotalMete += l.listMete);
    }), e.technologyListType === P.AUXILIARY_MATERIAL.V && (await ye(e.technologyList), await N(e.technologyList, { toNum: true }));
  }
  function q(s, e) {
    v.value && v.value.add({ material: s }, e);
  }
  function $(s, e) {
    g.value && g.value.add({ material: s }, e);
  }
  function j() {
    L.value = true;
  }
  function F(s) {
    y.value = s;
  }
  return (s, e) => {
    const l = ie, w = S("common-button"), z = S("common-radio-button"), Y = le, G = ne, Q = re, X = S("common-drawer"), W = C("split"), J = C("empty"), I = C("to-fixed");
    return k(), A(R, null, [c(X, oe({ ref: "drawerRef" }, s.$attrs, { visible: U.value, "before-close": i(o).cancelCU, title: t.value, "show-close": true, size: "100%", "close-on-click-modal": false, "custom-class": "project-preparation-form" }), { titleAfter: u(() => [c(l, { class: "info-tag filter-item", effect: "dark", type: "warning" }, { default: u(() => [e[4] || (e[4] = m(" 清单上传人：")), T(n("span", null, null, 512), [[W, b.value], [J]])]), _: 1, __: [4] })]), titleRight: u(() => [c(w, { loading: i(o).status.cu === i(_).STATUS.PROCESSING, size: "default", type: "primary", onClick: i(o).submitCU }, { default: u(() => e[5] || (e[5] = [m(" 提 交 ")])), _: 1, __: [5] }, 8, ["loading", "onClick"])]), content: u(() => [n("div", Le, [n("div", Ve, [c(i(he), { onAdd: q, onSelectedChange: F })]), n("div", we, [n("div", Ie, [n("div", Se, [c(z, { class: "filter-item", modelValue: a.value, "onUpdate:modelValue": e[0] || (e[0] = (f) => a.value = f), options: r, type: "enum", size: "default" }, null, 8, ["modelValue"]), n("div", Ce, [c(Y, { modelValue: h.value.showOnlySelectTechInfo, "onUpdate:modelValue": e[1] || (e[1] = (f) => h.value.showOnlySelectTechInfo = f), label: "只显示选中的清单的备料信息", size: "default", border: "" }, null, 8, ["modelValue"])]), i(o).form.materialBasicClass & i(_e) ? (k(), A(R, { key: 0 }, [c(l, { class: "info-tag filter-item", effect: "plain", type: "info" }, { default: u(() => [e[6] || (e[6] = m(" 清单汇总量： ")), T(n("span", null, null, 512), [[I, { val: i(o).props.listTotalMete || 0, k: "COM_WT__KG" }]]), e[7] || (e[7] = m(" kg "))]), _: 1, __: [6, 7] }), c(l, { class: "info-tag filter-item", effect: "plain", type: "success" }, { default: u(() => [e[8] || (e[8] = m(" 库存利用量： ")), T(n("span", null, null, 512), [[I, { val: i(o).props.inventoryTotalMete || 0, dp: i(K).weight.precision }]]), e[9] || (e[9] = m(" kg "))]), _: 1, __: [8, 9] }), c(l, { class: "info-tag filter-item", effect: "plain", type: "warning" }, { default: u(() => [e[10] || (e[10] = m(" 需要采购量： ")), T(n("span", null, null, 512), [[I, { val: i(o).props.purchaseTotalMete || 0, dp: i(K).weight.precision }]]), e[11] || (e[11] = m(" kg "))]), _: 1, __: [10, 11] })], 64)) : x("", true)]), n("div", ke, [a.value === r.PURCHASE_LIST.V ? (k(), ae(w, { key: 0, class: "filter-item", type: "success", size: "default", disabled: !y.value || i(o).props.boolTechEditMode, onClick: j }, { default: u(() => e[12] || (e[12] = [m(" 新增材料 ")])), _: 1, __: [12] }, 8, ["disabled"])) : x("", true)])]), n("div", Ne, [n("div", Ee, [n("div", Ue, [c(G, { ref_key: "formRef", ref: E, model: i(V), size: "default", "label-position": "top", inline: "", "label-width": "200px" }, { default: u(() => [c(ve, { ref_key: "inventoryTableRef", ref: v, show: a.value === r.INVENTORY_LIST.V, "current-tech-row": y.value, "query-filter": h.value, height: i(M) }, null, 8, ["show", "current-tech-row", "query-filter", "height"]), c(ge, { ref_key: "purchaseTableRef", ref: g, show: a.value === r.PURCHASE_LIST.V, "current-tech-row": y.value, "query-filter": h.value, height: i(M) }, null, 8, ["show", "current-tech-row", "query-filter", "height"])]), _: 1 }, 8, ["model"])])]), n("div", { class: "preparation-remark-info", style: se(i(B)) }, [c(Q, { class: "remark", modelValue: i(V).remark, "onUpdate:modelValue": e[2] || (e[2] = (f) => i(V).remark = f), rows: 5, type: "textarea", placeholder: "备注", maxlength: "1000", "show-word-limit": "", style: { width: "100%" } }, null, 8, ["modelValue"]), e[13] || (e[13] = n("div", { class: "tip-list" }, [n("span", { class: "tip" }, " * 备料单保存提交后，“库存利用清单”中相对应的物料，会在物料仓被冻结（被冻结的物料只可以被对应备料单绑定的项目出库）。 "), n("span", { class: "tip" }, " * 冻结的物料被出库，则“库存利用清单”中物料的可利用最小数量为：“当前备料单数量” - (“项目下所有物料单备料冻结总数量 - 冻结出库数量”)。 ")], -1))], 4)])])])]), _: 1 }, 16, ["visible", "before-close", "title"]), c(Te, { modelValue: L.value, "onUpdate:modelValue": e[3] || (e[3] = (f) => L.value = f), "technology-row": y.value, onSuccess: $ }, null, 8, ["modelValue", "technology-row"])], 64);
  };
} }, Xe = ue(Me, [["__scopeId", "data-v-08e77a4d"]]);
export {
  Xe as default
};
