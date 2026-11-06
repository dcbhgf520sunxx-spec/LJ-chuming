import { ref as s } from "vue";
import { watchEffect as j } from "vue";
import { nextTick as C } from "vue";
import { watch as ge } from "vue";
import { resolveComponent as F } from "vue";
import { openBlock as V } from "vue";
import { createBlock as T } from "vue";
import { withCtx as u } from "vue";
import { createElementVNode as p } from "vue";
import { createVNode as a } from "vue";
import { unref as i } from "vue";
import { createElementBlock as U } from "vue";
import { toDisplayString as S } from "vue";
import { createCommentVNode as E } from "vue";
import { createTextVNode as f } from "vue";
import { withDirectives as O } from "vue";
import { vShow as z } from "vue";
import { ElFormItem as fe } from "element-plus";
import { ElInput as ve } from "element-plus";
import { ElPopover as ye } from "element-plus";
import { ElDatePicker as be } from "element-plus";
import { ElInputNumber as Ve } from "element-plus";
import { ElTag as he } from "element-plus";
import { ElDivider as we } from "element-plus";
import { ElForm as Se } from "element-plus";
import { d as xe } from "../../../../modules/dept-398bb184.js";
import { _ as _e, t as De, g8 as Ie, jA as L, kc as Ne, bC as Me, bN as je, gD as x, cy as J, kt as Te, c7 as Ue, iH as Ee, ia as Be, R as ke, S as Ae, b as P } from "../../../../shared/runtime.js";
import { _ as Re } from "../../../../modules/region-cascader-39b54da2.js";
import { m as qe } from "../../../../modules/tree-select-86c0f12c.js";
const Ce = { key: 0, style: { width: "35px" } }, Fe = { style: { width: "200px" } }, Oe = { style: { color: "#82848a" } }, ze = { class: "ratio" }, Le = { class: "ratio-container" }, Je = { key: 0, class: "contractSign-container" }, Pe = { key: 1, class: "manage-container" }, Ge = { class: "form-row" }, $e = { class: "form-row" }, He = { class: "form-row" }, Qe = { class: "form-row" }, We = { style: { width: "280px" } }, Ye = { class: "upload-box" }, Ke = { __name: "base-form", props: { formData: { type: Object, default: () => {
} }, isEdit: { type: Boolean, default: false }, isDisabledSN: { type: Boolean, default: false } }, setup(m, { expose: G }) {
  const { decimalPrecision: $ } = De(), c = s(), B = s(), g = s(), H = s(), Q = s(), _ = s(false), k = s([]), h = Ie(["margin_type", "currency_type", "info_source", "party_type", "structure_status", "sending_mode"]), A = { id: void 0, serialNumber: void 0, name: void 0, shortName: void 0, region: [], countryId: void 0, provinceId: void 0, cityId: void 0, regionId: void 0, address: void 0, startDate: (/* @__PURE__ */ new Date()).getTime(), endDate: void 0, contractAmount: void 0, prepayments: void 0, managementFeeRate: void 0, marginAmount: void 0, marginType: void 0, currencyType: void 0, projectManagerId: void 0, salesLeaderId: void 0, businessLeaderId: void 0, businessLeaderTwoId: void 0, attachmentFiles: [], attachments: [], infoSource: void 0, structureStatusName: void 0, sendingModeName: void 0, partyTypeName: void 0, structureStatus: void 0, isBuilding: L.FALSE.V, projectManagerScale: void 0, contractSignBodyScale: void 0 }, e = s(JSON.parse(JSON.stringify(A))), W = (r, l, n) => {
    l ? n() : n(new Error("合同金额必须大于0"));
  }, Y = (r, l, n) => {
    if (e.value.projectAttribute === 2) {
      const o = e.value.contractSignBodyScale, d = e.value.projectManagerScale;
      o == null || d == null ? n(new Error("请填写所有比例")) : o + d !== 100 ? n(new Error("比例相加必须等于100")) : n();
    } else n();
  }, K = (r, l, n) => {
    l === 0 ? n(new Error("质保金不能等于0")) : n();
  }, X = (r, l, n) => {
    if (e.value.projectAttribute === 2) {
      if (P(l)) return n(new Error("请输入合同签约方比例"));
      n();
    } else n();
  }, Z = (r, l, n) => {
    if (e.value.projectAttribute === 2) {
      if (P(l)) return n(new Error("请输入项目经理比例"));
      n();
    } else n();
  };
  j(() => {
    e.value.contractSignBodyScale && e.value.projectManagerScale && C(() => {
      g.value.validateField("combinedRatio");
    });
  });
  const ee = { businessType: [{ required: true, message: "请选择订单类型", trigger: "change" }], projectAttribute: [{ required: true, message: "请选择经营方式", trigger: "change" }], deptId: [{ required: true, message: "请选择承接部门", trigger: "change" }], projectManagerId: [{ required: true, message: "请选择项目经理", trigger: "change" }], salesLeaderId: [{ required: true, message: "请选择销售负责人", trigger: "change" }], signingDate: [{ required: true, message: "请选择签订日期", trigger: "change" }], region: [{ required: true, message: "请选择项目地点", trigger: "change" }], structureArea: [{ required: true, message: "请填写建筑面积", trigger: "blur" }], serialNumber: [{ required: true, message: "请填写合同编号", trigger: "blur" }, { min: 1, max: 60, message: "长度在 1 到 60 个字符", trigger: "blur" }], startDate: [{ required: true, message: "请选择开工日期", trigger: "change" }], endDate: [{ required: true, message: "请选择完工日期", trigger: "change" }], contractSignBodyId: [{ required: true, message: "请选择合同签订主体（签订主体可在配置管理-基础配置-分支机构中创建）", trigger: "change" }], structureStatus: [{ required: true, message: "请选择结构类型", trigger: "change" }], partyType: [{ required: true, message: "请选择甲方类型", trigger: "change" }], sendingMode: [{ required: true, message: "请选择发包类型", trigger: "change" }], infoSource: [{ required: true, message: "请选择信息来源", trigger: "change" }], name: [{ required: true, message: "请填写项目名称", trigger: "blur" }, { min: 1, max: 100, message: "长度在 1 到 100 个字符", trigger: "blur" }], shortName: [{ required: true, message: "请填写项目简称", trigger: "blur" }, { min: 1, max: 17, message: "长度在 1 到 17 个字符", trigger: "blur" }], contractAmount: [{ required: true, validator: W, trigger: "blur" }], address: [{ max: 220, message: "长度不超过 220 个字符", trigger: "blur" }], combinedRatio: [{ validator: Y, trigger: "change" }], contractSignBodyScale: [{ validator: X, message: "请输入合同签约方比例", trigger: "change" }], projectManagerScale: [{ validator: Z, message: "请输入项目经理比例", trigger: "change" }], signingAddress: [{ max: 220, message: "长度不超过 220 个字符", trigger: "blur" }], signerId: [{ required: true, message: "请填写销售负责人", trigger: "change" }], qualityGuaranteeDeposit: [{ validator: K, trigger: "blur" }] }, R = m;
  ge(() => R.formData, (r) => {
    oe(r);
  }, { deep: true, immediate: true });
  const v = s([]), le = (r) => {
    if (!r) {
      e.value.projectAttribute = "", v.value = [];
      return;
    }
    const l = Object.values(x.V);
    switch (r) {
      case 1:
        v.value = l.filter((n) => n.V === 1);
        break;
      case 4:
        v.value = l.filter((n) => n.V === 1 || n.V === 3);
        break;
      default:
        v.value = l;
    }
  }, y = s([]);
  j(() => {
    var r, l;
    if (c.value && !(!((r = c.value) != null && r.options) && !e.value.businessType)) switch (y.value.length || (y.value = ((l = c == null ? void 0 : c.value) == null ? void 0 : l.options) || []), e.value.businessType) {
      case 1:
        c.value.options = y.value;
        break;
      case 2:
        c.value.options = y.value.filter((n) => n.level === 1);
        break;
      case 4:
        c.value.options = y.value;
        break;
      default:
        c.value.options = y.value;
    }
  });
  const { crud: q } = Ne(), D = s(""), I = s("");
  j(() => {
    var r, l, n;
    if ((r = e.value) != null && r.projectId) {
      const o = (l = q.data.find((w) => w.id === e.value.projectId)) == null ? void 0 : l.contractSignBodyName;
      o && (D.value = o);
      const d = (n = q.data.find((w) => w.id === e.value.projectId)) == null ? void 0 : n.projectManagerName;
      d && (I.value = d);
    }
  });
  const ae = (r) => {
    D.value = r == null ? void 0 : r.name;
  }, te = (r) => {
    r || (e.value.projectManagerScale = ""), I.value = B.value.getNodeInfo().label;
  };
  ne();
  async function ne() {
    try {
      k.value = await xe({ hasRoot: true });
    } catch (r) {
      console.log("部门tree", r);
    }
  }
  function re(r) {
    e.value.deptId = r.id, e.value.deptName = r.name, _.value = false;
  }
  function oe(r) {
    g.value && g.value.resetFields();
    let l;
    r && Object.keys(r).length > 0 ? l = r : l = JSON.parse(JSON.stringify(A)), e.value = JSON.parse(JSON.stringify(l)), g.value && C(() => {
      g.value.clearValidate();
    }), Me(g, e);
  }
  async function ue() {
    var r;
    try {
      const l = await g.value.validate();
      if (l) {
        const n = JSON.parse(JSON.stringify(e.value));
        n.attachments = ((r = n.attachmentFiles) == null ? void 0 : r.length) > 0 ? n.attachmentFiles.map((o) => o.id) : [], Object.assign(R.formData, n);
      }
      return l;
    } catch (l) {
      return console.log("error", l), false;
    }
  }
  function ie(r) {
    switch (r || (e.value.salesLeaderId = void 0, e.value.projectManagerId = void 0), r) {
      case 1:
        e.value.projectManagerId = void 0, e.value.projectManagerScale = void 0, e.value.contractSignBodyScale = void 0;
        break;
      case 2:
        e.value.salesLeaderId = void 0;
        break;
      case 3:
        e.value.salesLeaderId = void 0, e.value.projectManagerScale = void 0, e.value.contractSignBodyScale = void 0;
    }
  }
  function de(r) {
    return e.value.startDate ? r.getTime() - 864e4 < e.value.startDate : r.getTime() - 864e4 < (/* @__PURE__ */ new Date()).getTime();
  }
  function se(r) {
    e.value.countryId = void 0, e.value.provinceId = void 0, e.value.cityId = void 0, e.value.regionId = void 0, r && r.forEach((l, n) => {
      n === 0 && (e.value.countryId = l), n === 1 && (e.value.provinceId = l), n === 2 && (e.value.cityId = l), n === 3 && (e.value.regionId = l);
    });
  }
  return G({ validateForm: ue }), (r, l) => {
    const n = F("common-select"), o = fe, d = ve, w = ye, N = be, b = Ve, pe = F("common-radio"), M = he, me = we, ce = Se;
    return V(), T(ce, { ref_key: "formRef", ref: g, model: e.value, rules: ee, class: "form-margin", inline: "", "label-position": "right", size: "small" }, { default: u(() => [p("div", null, [a(o, { label: "订单类型", prop: "businessType" }, { default: u(() => [a(n, { modelValue: e.value.businessType, "onUpdate:modelValue": l[0] || (l[0] = (t) => e.value.businessType = t), disabled: m.isEdit || m.isDisabledSN, options: i(je).ENUM, class: "input-underline", clearable: "", placeholder: "订单类型", size: "small", style: { width: "200px" }, type: "enum", onChange: le }, null, 8, ["modelValue", "disabled", "options"])]), _: 1 }), a(o, { label: "经营方式", prop: "projectAttribute" }, { default: u(() => [a(n, { modelValue: e.value.projectAttribute, "onUpdate:modelValue": l[1] || (l[1] = (t) => e.value.projectAttribute = t), disabled: e.value.haveMonomer === 1 || m.isEdit || m.isDisabledSN, options: v.value.length ? v.value : i(x).ENUM, class: "input-underline", clearable: "", placeholder: "经营方式", size: "small", style: { width: "200px" }, type: "enum", onChange: ie }, null, 8, ["modelValue", "disabled", "options"])]), _: 1 }), a(o, { label: "承接部门", prop: "deptId" }, { default: u(() => [a(w, { ref_key: "menuPopover", ref: H, visible: _.value, "onUpdate:visible": l[3] || (l[3] = (t) => _.value = t), placement: "bottom-start", trigger: "click", width: "450" }, { reference: u(() => [a(d, { modelValue: e.value.deptName, "onUpdate:modelValue": l[2] || (l[2] = (t) => e.value.deptName = t), class: "input-underline", placeholder: "点击选择所属部门", readonly: "", style: { width: "200px" } }, null, 8, ["modelValue"])]), default: u(() => [a(qe, { ref_key: "menuSelectRef", ref: Q, defaultProps: { children: "children", label: "name" }, pid: e.value.deptId, treeMenu: k.value, style: { width: "400px" }, onSelected: re }, null, 8, ["pid", "treeMenu"])]), _: 1 }, 8, ["visible"])]), _: 1 }), e.value.projectAttribute === i(x).LUMP_SUM_SYSTEM.V || e.value.projectAttribute === i(x).JOINT_VENTURE.V ? (V(), T(o, { key: 0, label: "项目经理", prop: "projectManagerId" }, { default: u(() => [a(J, { ref_key: "userDeptRef", ref: B, modelValue: e.value.projectManagerId, "onUpdate:modelValue": l[4] || (l[4] = (t) => e.value.projectManagerId = t), "collapse-tags": false, disabled: m.isEdit || m.isDisabledSN, nofilterBlankDept: "", class: "input-underline", clearable: "", filterable: "", placeholder: "项目经理", style: { width: "200px" }, onChange: te }, null, 8, ["modelValue", "disabled"])]), _: 1 })) : (V(), T(o, { key: 1, label: "销售负责人", prop: "salesLeaderId" }, { default: u(() => [a(J, { modelValue: e.value.salesLeaderId, "onUpdate:modelValue": l[5] || (l[5] = (t) => e.value.salesLeaderId = t), "collapse-tags": false, disabled: m.isEdit || m.isDisabledSN, nofilterBlankDept: "", class: "input-underline", clearable: "", filterable: "", placeholder: "销售负责人", style: { width: "200px" } }, null, 8, ["modelValue", "disabled"])]), _: 1 })), a(o, { label: "签订日期", prop: "signingDate" }, { default: u(() => [a(N, { modelValue: e.value.signingDate, "onUpdate:modelValue": l[6] || (l[6] = (t) => e.value.signingDate = t), class: "input-underline", placeholder: "选择签订日期", style: { width: "200px" }, type: "date", "value-format": "x" }, null, 8, ["modelValue"])]), _: 1 }), a(o, { label: "合同编号", prop: "serialNumber" }, { default: u(() => [a(d, { modelValue: e.value.serialNumber, "onUpdate:modelValue": l[7] || (l[7] = (t) => e.value.serialNumber = t), modelModifiers: { trim: true }, disabled: m.isDisabledSN, class: "input-underline", placeholder: "合同编号", style: { width: "200px" } }, null, 8, ["modelValue", "disabled"])]), _: 1 }), a(o, { label: "项目名称", prop: "name" }, { default: u(() => [a(d, { modelValue: e.value.name, "onUpdate:modelValue": l[8] || (l[8] = (t) => e.value.name = t), modelModifiers: { trim: true }, class: "input-underline", placeholder: "项目名称", style: { width: "340px" } }, null, 8, ["modelValue"])]), _: 1 }), a(o, { label: "项目简称", prop: "shortName" }, { default: u(() => [a(d, { modelValue: e.value.shortName, "onUpdate:modelValue": l[9] || (l[9] = (t) => e.value.shortName = t), modelModifiers: { trim: true }, class: "input-underline", maxlength: "12", placeholder: "项目简称", style: { width: "320px" } }, null, 8, ["modelValue"])]), _: 1 }), a(o, { label: "结构工程量", prop: "structureArea" }, { default: u(() => [a(b, { modelValue: e.value.structureArea, "onUpdate:modelValue": l[10] || (l[10] = (t) => e.value.structureArea = t), controls: false, max: 999999999999, min: 0, step: 1, class: "input-underline", "controls-position": "right", placeholder: "结构工程量", precision: "3", style: { width: "200px" } }, null, 8, ["modelValue"]), a(n, { modelValue: e.value.unitType, "onUpdate:modelValue": l[11] || (l[11] = (t) => e.value.unitType = t), options: i(Te).ENUM, style: { width: "100px" }, type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), a(o, { label: "项目地点", prop: "region" }, { default: u(() => [a(i(Re), { ref: "region", modelValue: e.value.region, "onUpdate:modelValue": l[12] || (l[12] = (t) => e.value.region = t), class: "input-underline", clearable: "", filterable: "", style: { width: "400px" }, onChange: se }, null, 8, ["modelValue"])]), _: 1 }), a(o, { label: "详细地址", prop: "address" }, { default: u(() => [a(d, { modelValue: e.value.address, "onUpdate:modelValue": l[13] || (l[13] = (t) => e.value.address = t), modelModifiers: { trim: true }, class: "input-underline", maxlength: "200", placeholder: "项目详细地址", style: { width: "930px" } }, null, 8, ["modelValue"])]), _: 1 }), a(o, { label: "开工时间", prop: "startDate" }, { default: u(() => [a(N, { modelValue: e.value.startDate, "onUpdate:modelValue": l[14] || (l[14] = (t) => e.value.startDate = t), class: "input-underline", placeholder: "选择约定开工日期", style: { width: "200px" }, type: "date", "value-format": "x" }, null, 8, ["modelValue"])]), _: 1 }), a(o, { label: "完工日期", prop: "endDate" }, { default: u(() => [a(N, { modelValue: e.value.endDate, "onUpdate:modelValue": l[15] || (l[15] = (t) => e.value.endDate = t), disabledDate: de, class: "input-underline", placeholder: "选择约定完成日期", style: { width: "200px" }, type: "date", "value-format": "x" }, null, 8, ["modelValue"])]), _: 1 }), a(o, { label: "总工期(天)", prop: "totalDuration" }, { default: u(() => [e.value.startDate && e.value.endDate ? (V(), U("div", Ce, S(i(Ue)(e.value.startDate, e.value.endDate)), 1)) : E("", true)]), _: 1 }), a(o, { label: "合同签订主体", prop: "contractSignBodyId" }, { default: u(() => [a(Ee, { ref_key: "companySelectRef", ref: c, modelValue: e.value.contractSignBodyId, "onUpdate:modelValue": l[16] || (l[16] = (t) => e.value.contractSignBodyId = t), disabled: m.isEdit, class: "input-underline", default: "", placeholder: "合同签订主体", style: { width: "345px" }, onCurrentChange: ae }, null, 8, ["modelValue", "disabled"])]), _: 1 }), a(o, { label: "结构类型", prop: "structureStatus" }, { default: u(() => [a(n, { modelValue: e.value.structureStatus, "onUpdate:modelValue": l[17] || (l[17] = (t) => e.value.structureStatus = t), "data-structure": { key: "id", label: "label", value: "id" }, options: i(h).structure_status, class: "input-underline", placeholder: "结构类型", size: "small", style: { width: "200px" }, type: "other" }, null, 8, ["modelValue", "options"])]), _: 1 }), a(o, { label: "甲方类型", prop: "partyType" }, { default: u(() => [a(n, { modelValue: e.value.partyType, "onUpdate:modelValue": l[18] || (l[18] = (t) => e.value.partyType = t), "data-structure": { key: "id", label: "label", value: "id" }, options: i(h).party_type, class: "input-underline", clearable: "", placeholder: "企业类型", size: "small", style: { width: "200px" }, type: "other" }, null, 8, ["modelValue", "options"])]), _: 1 }), a(o, { label: "发包类型", prop: "sendingMode" }, { default: u(() => [a(n, { modelValue: e.value.sendingMode, "onUpdate:modelValue": l[19] || (l[19] = (t) => e.value.sendingMode = t), "data-structure": { key: "id", label: "label", value: "id" }, options: i(h).sending_mode, class: "input-underline", clearable: "", placeholder: "发包类型", size: "small", style: { width: "200px" }, type: "other" }, null, 8, ["modelValue", "options"])]), _: 1 }), a(o, { label: "装配式建筑", prop: "isBuilding" }, { default: u(() => [a(pe, { modelValue: e.value.isBuilding, "onUpdate:modelValue": l[20] || (l[20] = (t) => e.value.isBuilding = t), options: i(L).ENUM, style: { width: "130px" }, type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), a(o, { label: "信息来源", prop: "infoSource" }, { default: u(() => [a(n, { modelValue: e.value.infoSource, "onUpdate:modelValue": l[21] || (l[21] = (t) => e.value.infoSource = t), "data-structure": { key: "id", label: "label", value: "id" }, options: i(h).info_source, class: "input-underline", clearable: "", placeholder: "信息来源", size: "small", style: { width: "590px" }, type: "other" }, null, 8, ["modelValue", "options"])]), _: 1 }), a(o, { label: "合同金额(元)", prop: "contractAmount" }, { default: u(() => [p("div", Fe, [a(b, { modelValue: e.value.contractAmount, "onUpdate:modelValue": l[22] || (l[22] = (t) => e.value.contractAmount = t), controls: false, max: 999999999999, min: 0, precision: i($).contract, step: 1, class: "input-underline", "controls-position": "right", placeholder: "合同金额(元)", style: { width: "220px" } }, null, 8, ["modelValue", "precision"]), p("div", Oe, S(e.value.contractAmount ? i(Be)(e.value.contractAmount) : ""), 1)])]), _: 1 }), a(o, { label: "税率", prop: "taxRate" }, { default: u(() => [a(b, { modelValue: e.value.taxRate, "onUpdate:modelValue": l[23] || (l[23] = (t) => e.value.taxRate = t), controls: false, max: 100, min: 0, precision: 0, step: 1, class: "input-underline", "controls-position": "right", placeholder: "0-100", style: { width: "80px" } }, null, 8, ["modelValue"]), l[32] || (l[32] = f(" % "))]), _: 1, __: [32] }), a(o, { label: "币种", prop: "currencyType" }, { default: u(() => [a(n, { modelValue: e.value.currencyType, "onUpdate:modelValue": l[24] || (l[24] = (t) => e.value.currencyType = t), "data-structure": { key: "id", label: "label", value: "value" }, options: i(h).currency_type, class: "input-underline", clearable: "", placeholder: "币种", size: "small", style: { width: "200px" }, type: "other" }, null, 8, ["modelValue", "options"])]), _: 1 }), O(p("div", ze, [a(o, { label: "合营项目比例分割", prop: "combinedRatio" }, { default: u(() => [p("div", Le, [e.value.contractSignBodyId ? (V(), U("div", Je, [a(o, { prop: "contractSignBodyScale" }, { default: u(() => [a(M, { size: "mini" }, { default: u(() => [f(S(D.value), 1)]), _: 1 }), a(b, { modelValue: e.value.contractSignBodyScale, "onUpdate:modelValue": l[25] || (l[25] = (t) => e.value.contractSignBodyScale = t), controls: false, class: "input-underline", "controls-position": "right", placeholder: "输入占比", style: { width: "100px" } }, null, 8, ["modelValue"]), l[33] || (l[33] = f(" % "))]), _: 1, __: [33] })])) : E("", true), e.value.projectManagerId ? (V(), U("div", Pe, [a(o, { prop: "projectManagerScale" }, { default: u(() => [a(M, { size: "mini" }, { default: u(() => [f(S(I.value), 1)]), _: 1 }), a(b, { modelValue: e.value.projectManagerScale, "onUpdate:modelValue": l[26] || (l[26] = (t) => e.value.projectManagerScale = t), controls: false, class: "input-underline", "controls-position": "right", placeholder: "输入占比", style: { width: "100px" } }, null, 8, ["modelValue"]), l[34] || (l[34] = f(" % "))]), _: 1, __: [34] })])) : E("", true), O(a(M, { type: "warning" }, { default: u(() => l[35] || (l[35] = [f("*比例相加必须等于百分之百 ")])), _: 1, __: [35] }, 512), [[z, e.value.contractSignBodyId && e.value.projectManagerId]])])]), _: 1 })], 512), [[z, e.value.projectAttribute === 2]])]), p("div", Ge, [a(o, { label: "商务条款：", "label-width": "90px", prop: "commercialClause", style: { width: "90%" } }, { default: u(() => [a(d, { modelValue: e.value.commercialClause, "onUpdate:modelValue": l[27] || (l[27] = (t) => e.value.commercialClause = t), modelModifiers: { trim: true }, autosize: { minRows: 4, maxRows: 8 }, class: "input-underline", maxlength: "2000", placeholder: "付款方式，违约条款等描述", "show-word-limit": "", style: { width: "calc(100% - 120px)" }, type: "textarea" }, null, 8, ["modelValue"])]), _: 1 })]), p("div", $e, [a(o, { label: "技术条款：", "label-width": "90px", prop: "technologyClause", style: { width: "90%" } }, { default: u(() => [a(d, { modelValue: e.value.technologyClause, "onUpdate:modelValue": l[28] || (l[28] = (t) => e.value.technologyClause = t), modelModifiers: { trim: true }, autosize: { minRows: 4, maxRows: 8 }, class: "input-underline", maxlength: "2000", placeholder: "合同注明的技术条款描述", "show-word-limit": "", style: { width: "calc(100% - 120px)" }, type: "textarea" }, null, 8, ["modelValue"])]), _: 1 })]), p("div", He, [a(o, { label: "其他：", "label-width": "90px", prop: "otherRemarks", style: { width: "90%" } }, { default: u(() => [a(d, { modelValue: e.value.otherRemarks, "onUpdate:modelValue": l[29] || (l[29] = (t) => e.value.otherRemarks = t), modelModifiers: { trim: true }, autosize: { minRows: 4, maxRows: 8 }, class: "input-underline", maxlength: "2000", placeholder: "其他合同需要交底的说明", "show-word-limit": "", style: { width: "calc(100% - 120px)" }, type: "textarea" }, null, 8, ["modelValue"])]), _: 1 }), p("div", Qe, [a(o, { label: "质保金", prop: "qualityGuaranteeDeposit" }, { default: u(() => [p("div", We, [a(b, { modelValue: e.value.qualityGuaranteeDeposit, "onUpdate:modelValue": l[30] || (l[30] = (t) => e.value.qualityGuaranteeDeposit = t), controls: false, max: 100, min: 0, step: 1, class: "input-underline", "controls-position": "right", placeholder: "质保金", style: { width: "220px" } }, null, 8, ["modelValue"]), l[36] || (l[36] = f(" % "))])]), _: 1 })])]), a(me, null, { default: u(() => l[37] || (l[37] = [p("span", { class: "title" }, "合同附件", -1)])), _: 1, __: [37] }), p("div", Ye, [a(ke, { files: e.value.attachmentFiles, "onUpdate:files": l[31] || (l[31] = (t) => e.value.attachmentFiles = t), "file-classify": i(Ae).CONTRACT_ATT.V, "empty-text": "暂未上传合同附件", "show-download": "", showView: "" }, null, 8, ["files", "file-classify"])])]), _: 1 }, 8, ["model"]);
  };
} }, nl = _e(Ke, [["__scopeId", "data-v-c4e1501d"]]);
export {
  nl as default
};
