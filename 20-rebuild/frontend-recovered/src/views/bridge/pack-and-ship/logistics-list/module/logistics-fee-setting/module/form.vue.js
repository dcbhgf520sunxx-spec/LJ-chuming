import { ref as g } from "vue";
import { watch as W } from "vue";
import { resolveComponent as m } from "vue";
import { openBlock as c } from "vue";
import { createBlock as f } from "vue";
import { withCtx as n } from "vue";
import { createVNode as i } from "vue";
import { unref as e } from "vue";
import { createTextVNode as w } from "vue";
import { createElementVNode as E } from "vue";
import { ElRadioGroup as K } from "element-plus";
import { createCommentVNode as _ } from "vue";
import { normalizeClass as C } from "vue";
import { toDisplayString as R } from "vue";
import { ElFormItem as Y } from "element-plus";
import { ElRadio as J } from "element-plus";
import { ElInput as Q } from "element-plus";
import { ElInputNumber as X } from "element-plus";
import { ElTableColumn as Z } from "element-plus";
import { ElForm as $ } from "element-plus";
import { g as ee } from "../../../../../../../modules/base-6bc46ddf.js";
import { a as le } from "../../../../../../../modules/logistics-list-3b33cbe0.js";
import { _ as oe, t as ae, bB as d, ao as te, o as re, bD as T, bb as ie, bE as ne, bF as se, bG as pe, bH as de, bI as ue, aw as me } from "../../../../../../../shared/runtime.js";
const ce = { class: "table-top" }, fe = { __name: "form", setup(be) {
  const { decimalPrecision: x } = ae(), I = g(), M = g(), V = g([]), S = { id: void 0, projectId: void 0, supplierId: void 0, boolPersonalEnum: false, priceType: d.WEIGHT.V, boolUseEnum: false, price: void 0, tax: void 0, invoiceTypeEnum: void 0, list: [] }, { CRUD: b, crud: u, form: l } = te(S, I), v = g(d.WEIGHT.V), { maxHeight: k } = re({ extraBox: [".el-drawer__header", ".table-top"], wrapperBox: [".el-drawer__body"], navbar: false, extraHeight: 120 }, () => M.value.loaded), H = { projectId: [{ required: true, message: "请选择项目", trigger: "change" }], boolPersonalEnum: [{ required: true, message: "选择承运类型", trigger: "change" }], supplierId: [{ validator: (a, o, t) => {
    !o && !l.boolPersonalEnum ? t(new Error("请选择选择物流公司")) : t();
  }, trigger: "change" }], priceType: [{ required: true, message: "请选择计价方式", trigger: "change" }], price: [{ required: true, message: "请填写单价", trigger: "blur" }], invoiceTypeEnum: [{ validator: (a, o, t) => {
    o ? (o !== T.RECEIPT.V && (l.tax || t(new Error("请选择税率")), t()), t()) : t(new Error("请选择发票类型"));
  }, trigger: "blur" }], licensePlate: [{ validator: (a, o, t) => {
    !o && l.boolPersonalEnum ? t(new Error("请填写车牌/船牌号")) : t();
  }, trigger: "blur" }, { pattern: ue, message: "请填写正确的车牌/船牌号", trigger: "blur" }], carModel: [{ validator: (a, o, t) => {
    !o && l.boolPersonalEnum ? t(new Error("请选择车型")) : t();
  }, trigger: "change" }] }, L = { price: [{ validator: (a, o) => o.priceType !== l.priceType ? !!a : true, message: "请填写价格", trigger: "change" }] }, { tableValidate: z, wrongCellMask: D } = me({ rules: L });
  W(() => l.boolPersonalEnum, (a) => {
    l.id || (a ? l.invoiceTypeEnum = T.ORDINARY.V : l.invoiceTypeEnum = T.SPECIAL.V);
  }, { immediate: true });
  function G(a) {
    l.list.map((o) => {
      o.priceType = a;
    });
  }
  async function N() {
    l.list = [], V.value = [];
    try {
      const a = await ee(), t = (u.status.edit === b.STATUS.PREPARED ? await le(l.id) : {}).content || [];
      if (a.carModels && a.carModels.length > 0) for (let s = 0; s < a.carModels.length; s++) V.value.push({ name: a.carModels[s], key: s }), t.length > 0 && t.findIndex((p) => p.carModel === a.carModels[s]) > -1 ? l.list.push(t.find((p) => p.carModel === a.carModels[s])) : l.list.push({ carModel: a.carModels[s], price: void 0, priceType: l.priceType || d.WEIGHT.V, supplierPriceId: void 0 }), l.boolPersonalEnum && (t != null && t.length) && (l.priceType = t[0].priceType, l.price = t[0].price, l.carModel = t[0].carModel);
    } catch (a) {
      console.log("获取车型配置", a);
    }
  }
  return b.HOOK.afterToCU = (a, o) => {
    v.value = a.status.edit === b.STATUS.PREPARED ? a.form.priceType : d.WEIGHT.V, N();
  }, b.HOOK.beforeSubmit = (a, o) => {
    if (a.form.boolPersonalEnum && (a.form.linkList = [{ carModel: a.form.carModel, price: a.form.price, priceType: a.form.priceType }]), a.form.list.length > 0 && !a.form.boolPersonalEnum) {
      const { validResult: t, dealList: s } = z(a.form.list);
      if (t) a.form.list = s;
      else return t;
      a.form.linkList = [], a.form.list.map((p) => {
        p.price && p.price > 0 && (p.supplierPriceId = a.form.supplierPriceId, a.form.linkList.push(p));
      });
    }
  }, (a, o) => {
    const t = m("common-button"), s = Y, p = J, O = Q, q = m("common-select"), h = m("common-radio-button"), U = X, y = Z, j = m("common-radio"), A = m("common-table"), B = $, F = m("common-drawer");
    return c(), f(F, { ref_key: "drawerRef", ref: M, "append-to-body": "", "close-on-click-modal": false, "before-close": e(u).cancelCU, visible: e(u).status.cu > 0, title: e(u).status.title, size: "35%" }, { titleRight: n(() => [i(t, { loading: e(u).status.cu === 2, type: "primary", size: "default", onClick: e(u).submitCU }, { default: n(() => o[10] || (o[10] = [w("确认")])), _: 1, __: [10] }, 8, ["loading", "onClick"])]), content: n(() => [i(B, { ref_key: "formRef", ref: I, model: e(l), rules: H, size: "default", "label-width": "110px" }, { default: n(() => [E("div", ce, [i(s, { label: "选择项目", prop: "projectId" }, { default: n(() => [i(ie, { class: "input-underline", disabled: e(l).boolUseEnum, modelValue: e(l).projectId, "onUpdate:modelValue": o[0] || (o[0] = (r) => e(l).projectId = r), style: { width: "300px" }, clearable: "" }, null, 8, ["disabled", "modelValue"])]), _: 1 }), i(s, { label: "选择承运类型", prop: "boolPersonalEnum" }, { default: n(() => [i(e(K), { disabled: e(l).id, modelValue: e(l).boolPersonalEnum, "onUpdate:modelValue": o[1] || (o[1] = (r) => e(l).boolPersonalEnum = r), size: "default" }, { default: n(() => [i(p, { value: false }, { default: n(() => o[11] || (o[11] = [w("物流单位承运")])), _: 1, __: [11] }), i(p, { value: true }, { default: n(() => o[12] || (o[12] = [w("个人承运")])), _: 1, __: [12] })]), _: 1 }, 8, ["disabled", "modelValue"])]), _: 1 }), e(l).boolPersonalEnum ? (c(), f(s, { key: 0, label: "车牌/船牌号", prop: "licensePlate", class: "form-label-require" }, { default: n(() => [i(O, { class: "input-underline", modelValue: e(l).licensePlate, "onUpdate:modelValue": o[2] || (o[2] = (r) => e(l).licensePlate = r), modelModifiers: { trim: true }, placeholder: "车牌/船牌号", style: { width: "300px" } }, null, 8, ["modelValue"])]), _: 1 })) : _("", true), e(l).boolPersonalEnum ? _("", true) : (c(), f(s, { key: 1, label: "选择物流公司", prop: "supplierId", class: "form-label-require" }, { default: n(() => [i(ne, { class: "input-underline", modelValue: e(l).supplierId, "onUpdate:modelValue": o[3] || (o[3] = (r) => e(l).supplierId = r), disabled: e(l).boolUseEnum, type: e(se).LOGISTICS.V, style: { width: "300px" } }, null, 8, ["modelValue", "disabled", "type"])]), _: 1 })), e(l).boolPersonalEnum ? (c(), f(s, { key: 2, label: "选择车型", prop: "carModel", class: "form-label-require" }, { default: n(() => [i(q, { modelValue: e(l).carModel, "onUpdate:modelValue": o[4] || (o[4] = (r) => e(l).carModel = r), options: V.value, clearable: "", dataStructure: { key: "key", label: "name", value: "name" }, type: "other", size: "default", placeholder: "车型", style: { width: "300px" }, class: "input-underline" }, null, 8, ["modelValue", "options"])]), _: 1 })) : _("", true), i(s, { label: "计价方式", prop: "priceType" }, { default: n(() => [i(h, { class: "filter-item", modelValue: e(l).priceType, "onUpdate:modelValue": o[5] || (o[5] = (r) => e(l).priceType = r), options: e(d).ENUM, type: "enum", size: "default" }, null, 8, ["modelValue", "options"])]), _: 1 }), i(s, { label: e(l).boolPersonalEnum ? "价格" : "基础价格", prop: "price" }, { default: n(() => [i(U, { modelValue: e(l).price, "onUpdate:modelValue": o[6] || (o[6] = (r) => e(l).price = r), max: 999999999999, class: "input-underline", precision: e(x).bridge, step: 100, controls: false, style: { width: "100px" }, placeholder: e(l).boolPersonalEnum ? "价格" : "基础价格", autocomplete: "off" }, null, 8, ["modelValue", "precision", "placeholder"]), E("span", { class: C(e(l).priceType === e(d).WEIGHT.V ? "blue" : "orange") }, R(e(d).V[e(l).priceType].unit), 3)]), _: 1 }, 8, ["label"]), i(s, { label: "发票及税率", prop: "invoiceTypeEnum", class: "form-label-require" }, { default: n(() => [i(pe, { class: "input-underline", invoiceType: e(l).invoiceTypeEnum, "onUpdate:invoiceType": o[7] || (o[7] = (r) => e(l).invoiceTypeEnum = r), taxRate: e(l).tax, "onUpdate:taxRate": o[8] || (o[8] = (r) => e(l).tax = r), style: { width: "360px" }, unshowOptions: e(l).boolPersonalEnum ? [e(T).SPECIAL.K] : [], classification: e(de).LOGISTICS.V, disabled: e(l).boolUseEnum }, null, 8, ["invoiceType", "taxRate", "unshowOptions", "classification", "disabled"])]), _: 1 })]), e(l).boolPersonalEnum ? _("", true) : (c(), f(A, { key: 0, ref: "detailRef", border: "", data: e(l).list, "max-height": e(k), style: { width: "100%" }, class: "table-form", "return-source-data": "", showEmptySymbol: false, "cell-class-name": e(D) }, { default: n(() => [i(y, { label: "序号", type: "index", align: "center", width: "55" }), i(y, { prop: "carModel", label: "车型", align: "center" }), i(y, { prop: "priceType", label: "计价方式", align: "center", "min-width": "270" }, { header: n(() => [o[13] || (o[13] = E("span", { style: { "margin-right": "3px", "vertical-align": "-3px" } }, "计价方式", -1)), i(h, { class: "filter-item", modelValue: v.value, "onUpdate:modelValue": o[9] || (o[9] = (r) => v.value = r), options: e(d).ENUM, type: "enum", size: "default", onChange: G }, null, 8, ["modelValue", "options"])]), default: n((r) => [i(j, { class: "filter-item", modelValue: r.row.priceType, "onUpdate:modelValue": (P) => r.row.priceType = P, options: e(d).ENUM, type: "enum", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])]), _: 1 }), i(y, { prop: "price", label: "价格", align: "center", width: "220" }, { default: n((r) => [i(U, { modelValue: r.row.price, "onUpdate:modelValue": (P) => r.row.price = P, modelModifiers: { number: true }, min: 0, max: 999999999999, step: 100, precision: e(x).bridge, placeholder: "价格", "controls-position": "right", style: { width: "150px", "margin-right": "3px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"]), E("span", { class: C(r.row.priceType === e(d).WEIGHT.V ? "blue" : "orange") }, R(e(d).V[r.row.priceType].unit), 3)]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "cell-class-name"]))]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, xe = oe(fe, [["__scopeId", "data-v-93830747"]]);
export {
  xe as default
};
