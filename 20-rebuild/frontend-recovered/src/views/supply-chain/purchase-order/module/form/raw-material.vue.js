import { ref as y } from "vue";
import { computed as H } from "vue";
import { watch as ye } from "vue";
import { resolveComponent as O } from "vue";
import { openBlock as p } from "vue";
import { createBlock as v } from "vue";
import { provide as he } from "vue";
import { watchEffect as ve } from "vue";
import { nextTick as xe } from "vue";
import { ElMessage as Ve } from "element-plus";
import { resolveDirective as Me } from "vue";
import { createElementBlock as E } from "vue";
import { createElementVNode as u } from "vue";
import { renderSlot as _e } from "vue";
import { createVNode as s } from "vue";
import { withCtx as r } from "vue";
import { createTextVNode as I } from "vue";
import { unref as l } from "vue";
import { createCommentVNode as h } from "vue";
import { normalizeStyle as Te } from "vue";
import { Fragment as L } from "vue";
import { renderList as Ue } from "vue";
import { toDisplayString as Ee } from "vue";
import { withModifiers as z } from "vue";
import { withDirectives as we } from "vue";
import { ElInput as Ae } from "element-plus";
import { ElFormItem as Ce } from "element-plus";
import { ElCheckbox as Ie } from "element-plus";
import { ElTag as Oe } from "element-plus";
import { ElTableColumn as Se } from "element-plus";
import { ElForm as Re } from "element-plus";
import { bl as q, v0 as G, jJ as F, am as M, b as Ne, _ as ke, jZ as Le, bD as Pe, bR as W, jU as Y, jV as J, jT as Z, tB as Be, vU as je, vV as ze, vW as He, cO as qe, jl as Fe, V as Q, b4 as De, ap as X, bE as $e, iH as Ke, cU as Ge, D as We, bG as Ye, bb as Je, R as Ze, S as Qe, jG as Xe, k5 as el, jH as ll } from "../../../../../shared/runtime.js";
const al = { __name: "basic-class-select", props: { modelValue: { type: [Array, Number] }, type: { type: [Number, String] }, size: { type: String, default: "default" }, multiple: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, filterable: { type: Boolean, default: false }, disabled: { type: Boolean, default: false }, collapseTags: { type: Boolean, default: false }, showOptionAll: { type: Boolean, default: false }, unshowOptions: { type: Array, default: () => [] }, showExtra: { type: Boolean, default: false }, extraOptionLabel: { type: String, default: "同上" }, extraOptionValue: { type: [Number, String, Array, Boolean], default: -1 }, placeholder: { type: String, default: "基础分类" }, textAlign: { type: String, default: "left" }, allLabelText: { type: String, default: "全部" }, allVal: { type: [Number, String], default: void 0 }, disabledVal: { type: Array, default: () => [] }, dataStructure: { type: Object } }, emits: ["change", "blur", "update:modelValue"], setup(_, { emit: P }) {
  const w = P, n = _, T = y(false), f = y(), U = H(() => {
    if (typeof n.type == "string") {
      if (n.type === "raw") return q.ENUM;
      if (n.type === "manuf") return G.ENUM;
    }
    if (typeof n.type == "number") {
      if (n.type === F.RAW_MATERIAL.V) return q.ENUM;
      if (n.type === F.MANUFACTURED.V) return G.ENUM;
    }
    return M.ENUM;
  });
  ye(() => n.modelValue, (m) => {
    f.value = m;
  }, { immediate: true });
  function e(m) {
    Ne(m) && (m = void 0), w("update:modelValue", m), w("change", m);
  }
  function b(m) {
    w("blur", m);
  }
  return (m, S) => {
    const B = O("common-select");
    return p(), v(B, { modelValue: f.value, "onUpdate:modelValue": S[0] || (S[0] = (R) => f.value = R), options: U.value, showExtra: n.showExtra, "extra-option-label": n.extraOptionLabel, "extra-option-value": n.extraOptionValue, size: n.size, disabled: _.disabled, multiple: n.multiple, placeholder: n.placeholder, "collapse-tags": n.collapseTags, loading: T.value, clearable: n.clearable, filterable: n.filterable, textAlign: n.textAlign, unshowOptions: n.unshowOptions, type: "enum", mode: "bit", onChange: e, onBlur: b }, null, 8, ["modelValue", "options", "showExtra", "extra-option-label", "extra-option-value", "size", "disabled", "multiple", "placeholder", "collapse-tags", "loading", "clearable", "filterable", "textAlign", "unshowOptions"]);
  };
} };
const tl = { style: { display: "flex" } }, sl = { style: { flex: "1", "text-align": "right" } }, il = { class: "main-content" }, ol = { class: "form-left" }, rl = { class: "order-details" }, nl = { class: "flex-rss child-mr-10" }, dl = { class: "flex-rss child-mr-10" }, ul = { class: "flex-rss child-mr-10" }, pl = { class: "input-underline flex-rss child-mr-10" }, ml = { class: "input-underline flex-rss child-mr-10" }, cl = { class: "form-right" }, fl = { class: "right-head flex-rbs" }, bl = { class: "assoc-preparation-list" }, gl = { key: 0, class: "opt-content" }, yl = { __name: "raw-material", props: { edit: { type: Boolean, default: false }, dialogVisible: { type: Boolean, default: false }, detail: { type: Object }, maxHeight: { type: Number, default: 100 }, heightStyle: { type: String, default: "" } }, emits: "success", setup(_, { emit: P }) {
  const w = { serialNumber: void 0, boolPartyA: false, supplyType: Le.SELF.V, purchaseType: F.RAW_MATERIAL.V, basicClass: null, isAllMaterial: false, auxMaterialIds: void 0, isAllOtherMaterial: false, otherMaterialIds: void 0, projectIds: void 0, requisitionsSN: void 0, supplierId: void 0, branchCompanyId: void 0, mete: void 0, amount: void 0, invoiceType: Pe.SPECIAL.V, taxRate: void 0, weightMeasurementMode: W.THEORY.V, logisticsTransportType: Y.FREIGHT.V, logisticsPayerType: J.SUPPLIER.V, purchaseOrderPaymentMode: Z.ARRIVAL.V, remark: void 0, attachments: void 0, attachmentIds: void 0, list: [] }, n = P, T = y(), f = _, { cu: U, form: e, FORM: b } = Be({ title: "采购合同", formStore: !f.edit, formStoreKey: "SUPPLY_CHAIN_PURCHASE_ORDER", defaultForm: w, useDraftCallback: m, clearDraftCallback: S, api: f.edit ? je : ze }, T, f.detail);
  he("cu", U);
  function m() {
  }
  function S() {
  }
  const B = (i, a, o) => {
    e.invoiceType || e.invoiceType === 0 ? o() : o(new Error("请选择发票及税率"));
  }, R = y({}), ee = { serialNumber: [{ max: 30, message: "订单编号长度不可超过30位", trigger: "blur" }], supplyType: [{ required: true, message: "请选择供货类型", trigger: "change" }], purchaseType: [{ required: true, message: "请选择物料种类", trigger: "change" }], basicClass: [{ required: true, message: "请选择物料类型", trigger: "change" }], supplierId: [{ required: true, message: "请选择供应商", trigger: "change" }], branchCompanyId: [{ required: true, message: "请选择签订主体", trigger: "change" }] }, le = { weightMeasurementMode: [{ required: true, message: "请选择计量方式", trigger: "change" }], logisticsTransportType: [{ required: true, message: "请选择物流运输方式", trigger: "change" }], logisticsPayerType: [{ required: true, message: "请选择物流费用承担方", trigger: "change" }], purchaseOrderPaymentMode: [{ required: true, message: "请选择订单类型", trigger: "change" }], invoiceType: [{ required: true, validator: B, trigger: "change" }], taxRate: [{ max: 2, message: "请输入税率", trigger: "blur" }], mete: [{ required: true, message: "请填写合同量", trigger: "blur" }], amount: [{ required: true, message: "请填写合同额", trigger: "blur" }] }, ae = { projectIds: [{ required: true, message: "请选择项目", trigger: "change" }] }, te = { auxMaterialIds: [{ required: true, validator: (i, a, o) => {
    e.isAllMaterial || a ? o() : o(new Error("请选择辅材"));
  }, trigger: "change" }] }, se = { otherMaterialIds: [{ required: true, validator: (i, a, o) => {
    e.isAllOtherMaterial || a ? o() : o(new Error("请选择其它科目"));
  }, trigger: "change" }] };
  ve(() => {
    if (f.dialogVisible) {
      const i = R.value;
      He(i), Object.assign(i, ee), e.boolPartyA ? (Object.assign(i, ae), delete i.supplierId) : Object.assign(i, le), e.basicClass & M.MATERIAL.V && Object.assign(i, te), e.basicClass & M.OTHER.V && Object.assign(i, se), xe(() => {
        T.value && T.value.clearValidate();
      });
    }
  });
  const ie = H(() => e.preparationSNList && e.preparationSNList.length > 0), c = y(), A = y(/* @__PURE__ */ new Map()), x = y([]), D = H(() => {
    let i = [];
    return c.value ? i = A.value.get(c.value) : i = x.value, i || [];
  }), V = y(false), N = y([]);
  b.HOOK.afterToAdd = () => {
  }, b.HOOK.afterToCU = () => {
    e.clickTime = (/* @__PURE__ */ new Date()).getTime();
  }, b.HOOK.beforeToCU = () => {
    c.value = void 0, A.value = /* @__PURE__ */ new Map(), x.value = [];
  }, b.HOOK.beforeToEdit = async (i, a) => {
    Array.isArray(a.preparationList) && a.preparationList.length > 0 && (await qe(a.preparationList), await Fe(a.preparationList, { toNum: true }), a.preparationList.forEach((o) => {
      const C = A.value.get(o.preparationSN);
      C ? C.push(o) : A.value.set(o.preparationSN, [o]);
      const d = x.value.findIndex((g) => g.serialNumber === o.serialNumber && g.color === o.color && g.brand === o.brand);
      if (d > -1) x.value[d].quantity += o.quantity, x.value[d].mete += o.mete, x.value[d].preparationSNList.push(o.preparationSN);
      else {
        const g = Q(o);
        g.preparationSNList = [o.preparationSN], x.value.push(g);
      }
    }));
  }, b.HOOK.beforeSubmit = () => {
    if (e.materialType = void 0, !$()) return false;
  }, b.HOOK.afterSubmit = () => {
    n("success");
  }, U.submitFormFormat = (i) => (i.attachmentIds = i.attachments ? i.attachments.map((a) => a.id) : void 0, i.auxMaterialIds = i.isAllMaterial ? [0] : i.auxMaterialIds, i.otherMaterialIds = i.isAllOtherMaterial ? [0] : i.otherMaterialIds, i);
  function oe(i) {
    if (!$()) return false;
    i !== c.value ? c.value = i : c.value = void 0;
  }
  function $() {
    return V.value ? (Ve.warning({ message: "请先“保存”或“取消编辑”分拣信息", duration: 4e3 }), false) : true;
  }
  function re() {
    V.value = true, N.value = Q(D.value);
  }
  function ne(i, a) {
    N.value.splice(a, 1);
  }
  function de() {
    V.value = false;
  }
  function ue() {
    V.value = false, A.value.set(c.value, N.value);
  }
  async function pe() {
    try {
      await U.submit();
    } catch (i) {
      console.log("采购合同提交", i);
    }
  }
  return (i, a) => {
    const o = O("common-button"), C = Ae, d = Ce, g = Ie, K = O("common-input-number"), k = O("common-radio"), me = Oe, j = Se, ce = O("common-table"), fe = Re, be = Me("split");
    return p(), E("div", null, [u("div", tl, [u("div", null, [_e(i.$slots, "chose", {}, void 0, true)]), u("div", sl, [s(o, { loading: l(U).status.edit === l(b).STATUS.PROCESSING, size: "default", type: "primary", onClick: pe }, { default: r(() => a[20] || (a[20] = [I(" 提 交 ")])), _: 1, __: [20] }, 8, ["loading"]), f.edit ? h("", true) : (p(), v(De, { key: 0, type: "cu" }))])]), u("div", il, [s(fe, { ref_key: "formRef", ref: T, model: l(e), rules: R.value, "label-position": "right", "label-width": "110px", size: "default" }, { default: r(() => [u("div", { style: Te(`height: ${_.maxHeight}px`), class: "form-content" }, [u("div", ol, [u("div", rl, [s(d, { class: "el-form-item-1", label: "采购合同编号", prop: "serialNumber" }, { default: r(() => [s(C, { modelValue: l(e).serialNumber, "onUpdate:modelValue": a[0] || (a[0] = (t) => l(e).serialNumber = t), modelModifiers: { trim: true }, disabled: l(e).boolUsed, class: "input-underline", maxlength: "30", placeholder: "可输入采购合同编号（不填写则自动生成）", size: "default" }, null, 8, ["modelValue", "disabled"])]), _: 1 }), s(d, { class: "el-form-item-3", label: "物料种类", prop: "basicClass" }, { default: r(() => [u("div", nl, [s(al, { modelValue: l(e).basicClass, "onUpdate:modelValue": a[1] || (a[1] = (t) => l(e).basicClass = t), disabled: l(e).boolUsed, type: l(e).purchaseType, unshowOptions: [l(q).GAS.K], class: "input-underline", clearable: "", multiple: "", placeholder: "请选择物料种类", style: { flex: "auto" } }, null, 8, ["modelValue", "disabled", "type", "unshowOptions"])])]), _: 1 }), l(e).basicClass & l(M).MATERIAL.V ? (p(), v(d, { key: 0, class: "el-form-item-5", label: "辅材明细", prop: "auxMaterialIds" }, { default: r(() => [u("div", dl, [s(g, { modelValue: l(e).isAllMaterial, "onUpdate:modelValue": a[2] || (a[2] = (t) => l(e).isAllMaterial = t), disabled: l(e).boolUsed, border: "", label: "所有辅材", size: "default", style: { "margin-top": "3px", "margin-right": "5px" } }, null, 8, ["modelValue", "disabled"]), s(X, { modelValue: l(e).auxMaterialIds, "onUpdate:modelValue": a[3] || (a[3] = (t) => l(e).auxMaterialIds = t), "basic-class": l(M).MATERIAL.V, "collapse-tags": false, deep: 2, disabled: l(e).boolUsed ? !!l(e).boolUsed : l(e).isAllMaterial, class: "input-underline", clearable: "", multiple: "", placeholder: "请选择辅材", separator: " > ", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "basic-class", "disabled"])])]), _: 1 })) : h("", true), l(e).basicClass & l(M).OTHER.V ? (p(), v(d, { key: 1, class: "el-form-item-5", label: "其它明细", prop: "otherMaterialIds" }, { default: r(() => [u("div", ul, [s(g, { modelValue: l(e).isAllOtherMaterial, "onUpdate:modelValue": a[4] || (a[4] = (t) => l(e).isAllOtherMaterial = t), disabled: l(e).boolUsed, border: "", label: "所有其它科目", size: "default", style: { "margin-top": "3px", "margin-right": "5px" } }, null, 8, ["modelValue", "disabled"]), s(X, { modelValue: l(e).otherMaterialIds, "onUpdate:modelValue": a[5] || (a[5] = (t) => l(e).otherMaterialIds = t), "basic-class": l(M).OTHER.V, "collapse-tags": false, deep: 2, disabled: l(e).boolUsed ? !!l(e).boolUsed : l(e).isAllOtherMaterial, class: "input-underline", clearable: "", multiple: "", placeholder: "请选择其它科目", separator: " > ", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "basic-class", "disabled"])])]), _: 1 })) : h("", true), s(d, { class: "el-form-item-7", label: "供应商", prop: "supplierId" }, { default: r(() => [s($e, { modelValue: l(e).supplierId, "onUpdate:modelValue": a[6] || (a[6] = (t) => l(e).supplierId = t), "basic-class": l(e).basicClass, disabled: l(e).boolUsed, type: l(e).purchaseType, class: "input-underline", clearable: "", filterable: "", mode: "contain" }, null, 8, ["modelValue", "basic-class", "disabled", "type"])]), _: 1 }), s(d, { class: "el-form-item-18", label: "签订主体", prop: "branchCompanyId" }, { default: r(() => [s(Ke, { modelValue: l(e).branchCompanyId, "onUpdate:modelValue": a[7] || (a[7] = (t) => l(e).branchCompanyId = t), disabled: l(e).boolUsed, class: "input-underline", default: "", placeholder: "合同签订主体", style: { width: "100%" } }, null, 8, ["modelValue", "disabled"])]), _: 1 }), l(e).boolPartyA ? h("", true) : (p(), E(L, { key: 2 }, [s(d, { class: "el-form-item-8", label: "合同量", prop: "mete", style: { display: "inline-flex", width: "320px" } }, { default: r(() => [u("div", pl, [s(K, { modelValue: l(e).mete, "onUpdate:modelValue": a[8] || (a[8] = (t) => l(e).mete = t), controls: false, disabled: l(e).boolUsed, max: 999999999999, step: 1, autocomplete: "off", placeholder: "请填写合同量", style: { width: "100%" } }, null, 8, ["modelValue", "disabled"]), s(Ge, { modelValue: l(e).meteUnit, "onUpdate:modelValue": a[9] || (a[9] = (t) => l(e).meteUnit = t), disabled: l(e).boolUsed, clearable: "", filterable: "", size: "default", style: { width: "80px", flex: "none" } }, null, 8, ["modelValue", "disabled"])])]), _: 1 }), s(d, { class: "el-form-item-9", label: "合同额", "label-width": "80px", prop: "amount", style: { display: "inline-flex", width: "240px" } }, { default: r(() => [u("div", ml, [s(K, { modelValue: l(e).amount, "onUpdate:modelValue": a[10] || (a[10] = (t) => l(e).amount = t), controls: false, disabled: l(e).boolUsed, max: 999999999999, precision: l(We).YUAN, step: 1, autocomplete: "off", class: "input-underline", placeholder: "请填写合同额", style: { width: "100%" } }, null, 8, ["modelValue", "disabled", "precision"]), a[21] || (a[21] = u("span", null, "元", -1))])]), _: 1 }), s(d, { class: "el-form-item-10", label: "发票及税率", prop: "invoiceType" }, { default: r(() => [s(Ye, { invoiceType: l(e).invoiceType, "onUpdate:invoiceType": a[11] || (a[11] = (t) => l(e).invoiceType = t), taxRate: l(e).taxRate, "onUpdate:taxRate": a[12] || (a[12] = (t) => l(e).taxRate = t), classification: l(e).basicClass, disabled: l(e).boolUsed, class: "input-underline" }, null, 8, ["invoiceType", "taxRate", "classification", "disabled"])]), _: 1 }), s(d, { class: "el-form-item-11", label: "计量方式", prop: "weightMeasurementMode" }, { default: r(() => [s(k, { modelValue: l(e).weightMeasurementMode, "onUpdate:modelValue": a[13] || (a[13] = (t) => l(e).weightMeasurementMode = t), disabled: l(e).boolUsed, options: l(W).ENUM, props: { key: "K", label: "SL", value: "V" }, size: "default", type: "enum" }, null, 8, ["modelValue", "disabled", "options"])]), _: 1 }), s(d, { class: "el-form-item-13", label: "订单类型", prop: "purchaseOrderPaymentMode" }, { default: r(() => [s(k, { modelValue: l(e).purchaseOrderPaymentMode, "onUpdate:modelValue": a[14] || (a[14] = (t) => l(e).purchaseOrderPaymentMode = t), disabled: l(e).boolUsed, options: l(Z).ENUM, size: "default", type: "enum" }, null, 8, ["modelValue", "disabled", "options"])]), _: 1 }), s(d, { class: "el-form-item-16", label: "物流运输方式", prop: "logisticsTransportType" }, { default: r(() => [s(k, { modelValue: l(e).logisticsTransportType, "onUpdate:modelValue": a[15] || (a[15] = (t) => l(e).logisticsTransportType = t), disabled: l(e).boolUsed, options: l(Y).ENUM, size: "default", type: "enum" }, null, 8, ["modelValue", "disabled", "options"])]), _: 1 }), s(d, { class: "el-form-item-17", label: "物流费用承担", prop: "logisticsPayerType" }, { default: r(() => [s(k, { modelValue: l(e).logisticsPayerType, "onUpdate:modelValue": a[16] || (a[16] = (t) => l(e).logisticsPayerType = t), disabled: l(e).boolUsed, options: l(J).ENUM, size: "default", type: "enum" }, null, 8, ["modelValue", "disabled", "options"])]), _: 1 })], 64)), s(d, { class: "el-form-item-4", label: "选择项目", "label-width": "80px", prop: "projectIds" }, { default: r(() => [s(Je, { modelValue: l(e).projectIds, "onUpdate:modelValue": a[17] || (a[17] = (t) => l(e).projectIds = t), disabled: l(e).boolUsed, class: "input-underline", clearable: "", multiple: "" }, null, 8, ["modelValue", "disabled"])]), _: 1 }), s(d, { class: "el-form-item-14", "label-width": "0", prop: "remark" }, { default: r(() => [s(C, { modelValue: l(e).remark, "onUpdate:modelValue": a[18] || (a[18] = (t) => l(e).remark = t), rows: 3, maxlength: "1000", placeholder: "备注", "show-word-limit": "", type: "textarea" }, null, 8, ["modelValue"])]), _: 1 }), s(Ze, { files: l(e).attachments, "onUpdate:files": a[19] || (a[19] = (t) => l(e).attachments = t), "file-classify": l(Qe).PURCHASE_ORDER_ATT.V, class: "el-form-item-15", "empty-text": "暂未上传采购合同附件", "show-download": "" }, null, 8, ["files", "file-classify"])])]), ie.value ? (p(), E(L, { key: 0 }, [a[26] || (a[26] = u("div", { class: "vertical-dashed-divider" }, null, -1)), u("div", cl, [u("div", fl, [u("span", bl, [a[22] || (a[22] = u("span", { class: "label" }, "关联备料单", -1)), (p(true), E(L, null, Ue(l(e).preparationSNList, (t) => (p(), v(me, { key: t, effect: c.value === t ? "dark" : "plain", class: "preparation-sn-tag", onClick: (ge) => oe(t) }, { default: r(() => [I(Ee(t), 1)]), _: 2 }, 1032, ["effect", "onClick"]))), 128))]), c.value ? (p(), E("span", gl, [V.value ? (p(), E(L, { key: 1 }, [s(o, { size: "default", onClick: z(de, ["stop"]) }, { default: r(() => a[24] || (a[24] = [I("取消编辑")])), _: 1, __: [24] }), s(o, { size: "default", type: "success", onClick: z(ue, ["stop"]) }, { default: r(() => a[25] || (a[25] = [I("保存")])), _: 1, __: [25] })], 64)) : (p(), v(o, { key: 0, size: "default", type: "warning", onClick: re }, { default: r(() => a[23] || (a[23] = [I(" 编辑分拣信息 ")])), _: 1, __: [23] }))])) : h("", true)]), s(ce, { ref: "tableRef", data: V.value ? N.value : D.value, "default-expand-all": false, "max-height": _.maxHeight - 150, "highlight-current-row": "", "row-key": "id" }, { default: r(() => [s(j, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), c.value ? h("", true) : (p(), v(j, { key: "preparationSNList", fixed: "left", label: "备料单号", "min-width": "140px", prop: "preparationSNList", "show-overflow-tooltip": "" }, { default: r(({ row: t }) => [we(u("span", null, null, 512), [[be, t.preparationSNList]])]), _: 1 })), s(Xe, { "show-index": false, fixed: "left", "spec-merge": "" }), s(el, { fixed: "left" }), s(ll), V.value ? (p(), v(j, { key: 1, align: "center", fixed: "right", label: "操作", width: "80px" }, { default: r(({ $index: t }) => [s(o, { icon: "el-icon-delete", size: "default", type: "danger", onClick: z((ge) => ne(t), ["stop"]) }, null, 8, ["onClick"])]), _: 1 })) : h("", true)]), _: 1 }, 8, ["data", "max-height"])])], 64)) : h("", true)], 4)]), _: 1 }, 8, ["model", "rules"])])]);
  };
} }, Ml = ke(yl, [["__scopeId", "data-v-c0c6984c"]]);
export {
  Ml as default
};
