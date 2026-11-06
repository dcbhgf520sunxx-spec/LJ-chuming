import { ref as u } from "vue";
import { watch as J } from "vue";
import { onMounted as Q } from "vue";
import { resolveComponent as c } from "vue";
import { openBlock as T } from "vue";
import { createBlock as V } from "vue";
import { withCtx as r } from "vue";
import { createVNode as n } from "vue";
import { unref as e } from "vue";
import { createTextVNode as v } from "vue";
import { ElRadioGroup as X } from "element-plus";
import { createCommentVNode as R } from "vue";
import { createElementVNode as g } from "vue";
import { normalizeClass as S } from "vue";
import { toDisplayString as L } from "vue";
import { ElFormItem as Z } from "element-plus";
import { ElRadio as $ } from "element-plus";
import { ElInputNumber as ee } from "element-plus";
import { ElTableColumn as oe } from "element-plus";
import { ElForm as le } from "element-plus";
import { _ as te, bB as d, ao as ae, t as ie, bD as y, bE as ne, bF as re, bG as se, bH as pe, bI as de, j1 as ue, aw as me } from "../../../../../../../shared/runtime.js";
import { g as ce } from "../../../../../../../modules/base-6bc46ddf.js";
import { a as fe } from "../../../../../../../modules/logistics-list-3bbba372.js";
import { u as be } from "../../../../../../../modules/useTableHeight-90797a0b.js";
const ge = { class: "table-header" }, ye = { __name: "Form", setup(Ee) {
  const I = u(), z = u(), P = u([]), H = { id: void 0, unitId: void 0, projectId: void 0, supplierId: void 0, boolPersonalEnum: false, priceType: d.WEIGHT.V, boolUseEnum: false, price: void 0, tax: void 0, invoiceTypeEnum: void 0, list: [] }, { crud: m, form: o, CRUD: f } = ae(H, I), E = u(d.WEIGHT.V), w = u(), { maxHeight: D } = be({ tableRef: w, hasPagination: false }, 20), G = { unitId: [{ required: true, message: "请选择单位", trigger: "change" }], projectId: [{ required: true, message: "请选择项目", trigger: "change" }], boolPersonalEnum: [{ required: true, message: "选择承运类型", trigger: "change" }], supplierId: [{ validator: (t, l, a) => {
    !l && !o.boolPersonalEnum ? a(new Error("请选择选择物流公司")) : a();
  }, trigger: "change" }], priceType: [{ required: true, message: "请选择计价方式", trigger: "change" }], price: [{ required: true, message: "请填写单价", trigger: "blur" }], invoiceTypeEnum: [{ validator: (t, l, a) => {
    l ? (l !== y.RECEIPT.V && (o.tax || a(new Error("请选择税率")), a()), a()) : a(new Error("请选择发票类型"));
  }, trigger: "blur" }], licensePlate: [{ validator: (t, l, a) => {
    !l && o.boolPersonalEnum ? a(new Error("请填写车牌/船牌号")) : a();
  }, trigger: "blur" }, { pattern: de, message: "请填写正确的车牌/船牌号", trigger: "blur" }], carModel: [{ validator: (t, l, a) => {
    !l && o.boolPersonalEnum ? a(new Error("请选择车型")) : a();
  }, trigger: "change" }] }, h = u([]);
  async function N() {
    const t = await ue.get("/api/branchCompany", { pageNumber: 1, pageSize: 100 });
    h.value = t.content;
  }
  const { decimalPrecision: x } = ie(), O = { price: [{ validator: (t, l) => l.priceType !== o.priceType ? !!t : true, message: "请填写价格", trigger: "change" }] }, { tableValidate: k, wrongCellMask: F } = me({ rules: O }), j = u([]);
  J(() => o.boolPersonalEnum, (t) => {
    o.id || (t ? o.invoiceTypeEnum = y.ORDINARY.V : o.invoiceTypeEnum = y.SPECIAL.V);
  }, { immediate: true });
  function q(t) {
    o.list.map((l) => {
      l.priceType = t;
    });
  }
  async function A() {
    o.list = [], P.value = [];
    try {
      const t = await ce(), a = (m.status.edit === f.STATUS.PREPARED ? await fe(o.id) : {}).content || [];
      if (t.carModels && t.carModels.length > 0) for (let p = 0; p < t.carModels.length; p++) P.value.push({ name: t.carModels[p], key: p }), a.length > 0 && a.findIndex((s) => s.carModel === t.carModels[p]) > -1 ? o.list.push(a.find((s) => s.carModel === t.carModels[p])) : o.list.push({ carModel: t.carModels[p], price: void 0, priceType: o.priceType || d.WEIGHT.V, supplierPriceId: void 0 }), o.boolPersonalEnum && (a != null && a.length) && (o.priceType = a[0].priceType, o.price = a[0].price, o.carModel = a[0].carModel);
    } catch (t) {
      console.log("获取车型配置", t);
    }
  }
  return f.HOOK.afterToCU = (t, l) => {
    E.value = t.status.edit === f.STATUS.PREPARED ? t.form.priceType : d.WEIGHT.V, A();
  }, f.HOOK.beforeSubmit = (t, l) => {
    if (t.form.boolPersonalEnum && (t.form.linkList = [{ carModel: t.form.carModel, price: t.form.price, priceType: t.form.priceType }]), t.form.list.length > 0 && !t.form.boolPersonalEnum) {
      const { validResult: a, dealList: p } = k(t.form.list);
      if (a) t.form.list = p;
      else return a;
      t.form.linkList = [], t.form.list.map((s) => {
        s.price && s.price > 0 && (s.supplierPriceId = t.form.supplierPriceId, t.form.linkList.push(s));
      });
    }
  }, Q(() => {
    N();
  }), (t, l) => {
    const a = c("common-button"), p = c("common-select"), s = Z, C = $, M = c("common-radio-button"), U = ee, b = oe, W = c("common-radio"), B = c("common-table"), K = le, Y = c("common-drawer");
    return T(), V(Y, { ref_key: "drawerRef", ref: z, "before-close": e(m).cancelCU, "close-on-click-modal": false, title: e(m).status.title, visible: e(m).status.cu > 0, "append-to-body": "", size: "40%" }, { titleRight: r(() => [n(a, { loading: e(m).status.cu === 2, size: "default", type: "primary", onClick: e(m).submitCU }, { default: r(() => l[9] || (l[9] = [v("确认 ")])), _: 1, __: [9] }, 8, ["loading", "onClick"])]), content: r(() => [n(K, { ref_key: "formRef", ref: I, model: e(o), rules: G, "label-position": "right", style: { padding: "10px 0 10px 10px" } }, { default: r(() => [n(s, { label: "选择单位", prop: "unitId" }, { default: r(() => [n(p, { modelValue: e(o).unitId, "onUpdate:modelValue": l[0] || (l[0] = (i) => e(o).unitId = i), options: h.value, class: "input-underline", clearable: "", placeholder: "请选择单位", size: "default", style: { width: "300px" }, type: "other" }, null, 8, ["modelValue", "options"])]), _: 1 }), n(s, { label: "选择项目", prop: "projectId" }, { default: r(() => [n(p, { modelValue: e(o).projectId, "onUpdate:modelValue": l[1] || (l[1] = (i) => e(o).projectId = i), options: j.value, class: "input-underline", clearable: "", filterable: "", placeholder: "请选择项目", size: "default", style: { width: "300px" }, type: "other" }, null, 8, ["modelValue", "options"])]), _: 1 }), n(s, { label: "选择承运类型", prop: "boolPersonalEnum" }, { default: r(() => [n(e(X), { modelValue: e(o).boolPersonalEnum, "onUpdate:modelValue": l[2] || (l[2] = (i) => e(o).boolPersonalEnum = i), disabled: e(o).id, size: "default" }, { default: r(() => [n(C, { value: false }, { default: r(() => l[10] || (l[10] = [v("物流单位承运")])), _: 1, __: [10] }), n(C, { value: true }, { default: r(() => l[11] || (l[11] = [v("个人承运")])), _: 1, __: [11] })]), _: 1 }, 8, ["modelValue", "disabled"])]), _: 1 }), e(o).boolPersonalEnum ? R("", true) : (T(), V(s, { key: 0, class: "form-label-require", label: "选择物流公司", prop: "supplierId" }, { default: r(() => [n(ne, { modelValue: e(o).supplierId, "onUpdate:modelValue": l[3] || (l[3] = (i) => e(o).supplierId = i), disabled: e(o).boolUseEnum, type: e(re).LOGISTICS.V, class: "input-underline", style: { width: "300px" } }, null, 8, ["modelValue", "disabled", "type"])]), _: 1 })), n(s, { label: "计价方式", prop: "priceType" }, { default: r(() => [n(M, { modelValue: e(o).priceType, "onUpdate:modelValue": l[4] || (l[4] = (i) => e(o).priceType = i), options: e(d).ENUM, class: "filter-item", size: "default", type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), n(s, { label: e(o).boolPersonalEnum ? "价格" : "基础价格", prop: "price" }, { default: r(() => [n(U, { modelValue: e(o).price, "onUpdate:modelValue": l[5] || (l[5] = (i) => e(o).price = i), controls: false, max: 999999999999, placeholder: e(o).boolPersonalEnum ? "价格" : "基础价格", precision: e(x).mes, step: 100, autocomplete: "off", class: "input-underline", style: { width: "100px" } }, null, 8, ["modelValue", "placeholder", "precision"]), g("span", { class: S(e(o).priceType === e(d).WEIGHT.V ? "blue" : "orange") }, L(e(d).V[e(o).priceType].unit), 3)]), _: 1 }, 8, ["label"]), n(s, { class: "form-label-require", label: "发票及税率", prop: "invoiceTypeEnum" }, { default: r(() => [n(se, { invoiceType: e(o).invoiceTypeEnum, "onUpdate:invoiceType": l[6] || (l[6] = (i) => e(o).invoiceTypeEnum = i), taxRate: e(o).tax, "onUpdate:taxRate": l[7] || (l[7] = (i) => e(o).tax = i), classification: e(pe).LOGISTICS.V, disabled: e(o).boolUseEnum, unshowOptions: e(o).boolPersonalEnum ? [e(y).SPECIAL.K] : [], class: "input-underline", style: { width: "360px" } }, null, 8, ["invoiceType", "taxRate", "classification", "disabled", "unshowOptions"])]), _: 1 }), e(o).boolPersonalEnum ? R("", true) : (T(), V(B, { key: 1, ref_key: "detailRef", ref: w, "cell-class-name": e(F), data: e(o).list, "max-height": e(D), showEmptySymbol: false, border: "", class: "table-form", "return-source-data": "", style: { width: "100%" } }, { default: r(() => [n(b, { align: "center", label: "序号", type: "index", width: "50" }), n(b, { align: "center", label: "车型", prop: "carModel" }), n(b, { align: "center", label: "计价方式", "min-width": "270", prop: "priceType" }, { header: r(() => [g("div", ge, [l[12] || (l[12] = g("span", null, "计价方式", -1)), n(M, { modelValue: E.value, "onUpdate:modelValue": l[8] || (l[8] = (i) => E.value = i), options: e(d).ENUM, class: "filter-item", size: "default", type: "enum", onChange: q }, null, 8, ["modelValue", "options"])])]), default: r((i) => [n(W, { modelValue: i.row.priceType, "onUpdate:modelValue": (_) => i.row.priceType = _, options: e(d).ENUM, class: "filter-item", size: "default", type: "enum" }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])]), _: 1 }), n(b, { align: "center", label: "价格", prop: "price", width: "220" }, { default: r((i) => [n(U, { modelValue: i.row.price, "onUpdate:modelValue": (_) => i.row.price = _, modelModifiers: { number: true }, max: 999999999999, min: 0, precision: e(x).shipment, step: 100, "controls-position": "right", placeholder: "价格", style: { width: "150px", "margin-right": "3px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"]), g("span", { class: S(i.row.priceType === e(d).WEIGHT.V ? "blue" : "orange") }, L(e(d).V[i.row.priceType].unit), 3)]), _: 1 })]), _: 1 }, 8, ["cell-class-name", "data", "max-height"]))]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "title", "visible"]);
  };
} }, Me = te(ye, [["__scopeId", "data-v-8a236f1a"]]);
export {
  Me as default
};
