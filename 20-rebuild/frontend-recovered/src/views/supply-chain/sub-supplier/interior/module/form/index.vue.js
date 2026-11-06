import { ref as m } from "vue";
import { useStore as L } from "vuex";
import { computed as P } from "vue";
import { onMounted as q } from "vue";
import { watch as B } from "vue";
import { nextTick as _ } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as F } from "vue";
import { createBlock as z } from "vue";
import { withCtx as d } from "vue";
import { createVNode as o } from "vue";
import { createTextVNode as h } from "vue";
import { unref as a } from "vue";
import { createElementVNode as b } from "vue";
import * as O from "lodash";
import { ElButton as $ } from "element-plus";
import { ElDatePicker as G } from "element-plus";
import { ElFormItem as K } from "element-plus";
import { ElInput as Q } from "element-plus";
import { ElForm as W } from "element-plus";
import { _ as Y, ao as H, v5 as J, i as y, cy as X, fv as Z, jb as j, D as ee, R as te, iV as ae, iW as le } from "../../../../../../shared/runtime.js";
import oe from "../../components/supplier-select-sub/index.vue.js";
import re from "../../components/branch-company-select-sub.vue.js";
import ne from "../../components/invoice-type-select-private.vue.js";
import { g as se } from "../../../../../../modules/index-69cea220.js";
import "../../components/supplier-select-sub/module/add-supplier.vue.js";
const de = { class: "line-container" }, ie = { class: "input-underline flex-rss child-mr-10" }, ue = { __name: "index", setup(pe) {
  const C = m(), f = m(), v = { projectManagerId: void 0, projectId: void 0, userId: L().getters.user.id, signDate: (/* @__PURE__ */ new Date()).getTime(), subcontractClassId: void 0, supplierId: void 0, branchCompanyId: void 0, amount: void 0, serialNumber: void 0, invoiceType: void 0, taxRateTypeValue: void 0, attachmentIds: void 0, remark: void 0 }, { crud: r, form: e, CRUD: p } = H(v, f), w = P(() => r.status.cu > p.STATUS.NORMAL), T = { projectManagerId: [{ required: true, message: "请选择项目经理", trigger: ["change", "blur"] }], projectId: [{ required: true, message: "请选择项目", trigger: ["change", "blur"] }], signDate: [{ required: true, message: "请选择日期", trigger: ["change", "blur"] }], userId: [{ required: true, message: "请选择创建人", trigger: ["change", "blur"] }], subcontractClassId: [{ required: true, message: "请选择分供类型", trigger: ["change", "blur"] }], supplierId: [{ required: true, message: "请选择供应商", trigger: ["change", "blur"] }], branchCompanyId: [{ required: true, message: "请选择签订主体", trigger: ["change", "blur"] }], amount: [{ required: true, message: "请输入合同额", trigger: ["change", "blur"] }], invoiceType: [{ required: true, message: "请选择发票类型", trigger: ["change", "blur"] }], taxRateTypeValue: [{ required: true, message: "请选择税率", trigger: ["change", "blur"] }] }, x = m([]), R = async () => {
    try {
      const { content: n } = await ae();
      x.value = n;
    } catch (n) {
      console.log(n);
    }
  };
  q(async () => {
    await R();
  });
  const { projectAllType: U } = J(), I = m();
  (async () => {
    try {
      const n = await se();
      I.value = n;
    } catch (n) {
      console.log("获取项目经理列表失败", n);
    }
  })();
  async function S(n) {
    var t, s, u, i;
    e.branchCompanyId = void 0, y(e.projectId) ? (e.projects = (t = U.value) == null ? void 0 : t.find((c) => c.id === e.projectId), e.branchCompanyId = (s = e.projects) == null ? void 0 : s.contractSignBodyId, e.boolInSourcing = (u = e.projects) == null ? void 0 : u.level, e.projectAttribute = (i = e.projects) == null ? void 0 : i.projectAttribute) : e.projects = void 0;
  }
  B(() => e.branchCompanyId, (n) => {
    _(() => {
      y(e.projects) && (e.branchCompanyId = e.projects.contractSignBodyId);
    });
  }, { deep: true });
  const M = () => {
    f.value.validate(async (n) => {
      n && await A();
    });
  }, A = async () => {
    var t;
    let n = [];
    (t = r.form.attachmentIds) != null && t.length && (n = r.form.attachmentIds.map((s) => s.id));
    try {
      r.status.add = p.STATUS.PROCESSING;
      const s = O.cloneDeep(r.form);
      s.attachmentIds = n;
      const u = await r.submitFormFormat(s);
      r.submitResult = await r.crudApi.add(u), r.status.add = p.STATUS.NORMAL, r.resetForm(), r.ref.form && _(() => {
        r.ref.form.clearValidate();
      }), r.addSuccessNotify(), r.toQuery();
    } catch (s) {
      console.log("添加", s), r.status.add = p.STATUS.PREPARED;
    }
  };
  function k(n) {
    var s;
    const t = j.VK[n];
    e.basicClass = ((s = le[t]) == null ? void 0 : s.V) || false;
  }
  return (n, t) => {
    const s = $, u = G, i = K, c = g("common-select"), V = Q, D = g("common-input-number"), N = W, E = g("common-drawer");
    return F(), z(E, { ref_key: "drawerRef", ref: C, "before-close": a(r).cancelCU, "show-close": false, visible: w.value, "destroy-on-close": "", size: "620px", title: "分供合同创建" }, { titleRight: d(() => [o(s, { size: "default", type: "success", onClick: M }, { default: d(() => t[13] || (t[13] = [h("发起审批")])), _: 1, __: [13] }), o(s, { plain: "", size: "default", onClick: a(r).cancelCU }, { default: d(() => t[14] || (t[14] = [h("关闭")])), _: 1, __: [14] }, 8, ["onClick"])]), content: d(() => [o(N, { ref_key: "formRef", ref: f, model: a(e), rules: T, "label-position": "right", "label-width": "110px", size: "default" }, { default: d(() => [o(i, { label: "日期", prop: "signDate" }, { default: d(() => [o(u, { modelValue: a(e).signDate, "onUpdate:modelValue": t[0] || (t[0] = (l) => a(e).signDate = l), class: "input-underline", clearable: "", placeholder: "日期", style: { width: "100%" }, type: "date", "value-format": "x" }, null, 8, ["modelValue"])]), _: 1 }), o(i, { label: "创建人", prop: "userId" }, { default: d(() => [o(X, { modelValue: a(e).userId, "onUpdate:modelValue": t[1] || (t[1] = (l) => a(e).userId = l), class: "input-underline", clearable: "", filterable: "", placeholder: "创建人" }, null, 8, ["modelValue"])]), _: 1 }), o(i, { label: "项目经理", prop: "projectManagerId" }, { default: d(() => [o(c, { modelValue: a(e).projectManagerId, "onUpdate:modelValue": t[2] || (t[2] = (l) => a(e).projectManagerId = l), filterable: true, options: I.value, class: "input-underline", placeholder: "请选择项目经理", style: { width: "100%" }, onChange: a(e).boolInSourcing }, null, 8, ["modelValue", "options", "onChange"])]), _: 1 }), o(i, { label: "项目", prop: "projectId" }, { default: d(() => [o(Z, { modelValue: a(e).projectId, "onUpdate:modelValue": t[3] || (t[3] = (l) => a(e).projectId = l), disabled: !a(y)(a(e).projectManagerId), projectManagerId: a(e).projectManagerId, class: "input-underline", clearable: "", "is-not-self-support": "", placeholder: "请选择项目", onChange: S }, null, 8, ["modelValue", "disabled", "projectManagerId"])]), _: 1 }), o(i, { label: "分供类型", prop: "subcontractClassId" }, { default: d(() => [o(c, { modelValue: a(e).subcontractClassId, "onUpdate:modelValue": t[4] || (t[4] = (l) => a(e).subcontractClassId = l), options: a(j).ENUM, class: "input-underline", clearable: "", placeholder: "请选择分供类型", style: { width: "100%" }, type: "enum", onChange: k }, null, 8, ["modelValue", "options"])]), _: 1 }), o(i, { label: "供应商", prop: "supplierId" }, { default: d(() => [o(oe, { modelValue: a(e).supplierId, "onUpdate:modelValue": t[5] || (t[5] = (l) => a(e).supplierId = l), basicClass: a(e).basicClass, class: "input-underline", clearable: "", filterable: "", mode: "contain", placeholder: "请选择供应商", style: { width: "100%" } }, null, 8, ["modelValue", "basicClass"])]), _: 1 }), o(i, { label: "签约主体", prop: "branchCompanyId" }, { default: d(() => [o(re, { modelValue: a(e).branchCompanyId, "onUpdate:modelValue": t[6] || (t[6] = (l) => a(e).branchCompanyId = l), defaultLevel: a(e).boolInSourcing !== 3 ? a(e).boolInSourcing : "", class: "input-underline", clearable: "", placeholder: "合同签订主体", style: { width: "100%" } }, null, 8, ["modelValue", "defaultLevel"])]), _: 1 }), b("div", de, [o(i, { label: "合同编号" }, { default: d(() => [o(V, { modelValue: a(e).serialNumber, "onUpdate:modelValue": t[7] || (t[7] = (l) => a(e).serialNumber = l), class: "input-underline", placeholder: "不填写则默认生成", style: { width: "100%" } }, null, 8, ["modelValue"])]), _: 1 }), o(i, { label: "合同额", prop: "amount", style: { display: "inline-flex", width: "100%" } }, { default: d(() => [b("div", ie, [o(D, { modelValue: a(e).amount, "onUpdate:modelValue": t[8] || (t[8] = (l) => a(e).amount = l), controls: false, max: 999999999999, precision: a(ee).YUAN, step: 1, autocomplete: "off", placeholder: "请填写合同额", style: { width: "100%" } }, null, 8, ["modelValue", "precision"]), t[15] || (t[15] = b("span", null, "元", -1))])]), _: 1 })]), o(i, { class: "el-form-item-10", label: "发票及税率", prop: "invoiceType" }, { default: d(() => [o(ne, { invoiceType: a(e).invoiceType, "onUpdate:invoiceType": t[9] || (t[9] = (l) => a(e).invoiceType = l), taxRateTypeValue: a(e).taxRateTypeValue, "onUpdate:taxRateTypeValue": t[10] || (t[10] = (l) => a(e).taxRateTypeValue = l), disabled: a(e).boolUsed, class: "input-underline" }, null, 8, ["invoiceType", "taxRateTypeValue", "disabled"])]), _: 1 }), o(V, { modelValue: a(e).remark, "onUpdate:modelValue": t[11] || (t[11] = (l) => a(e).remark = l), modelModifiers: { trim: true }, rows: 3, maxlength: "1000", placeholder: "备注信息", "show-word-limit": "", style: { width: "100%" }, type: "textarea" }, null, 8, ["modelValue"]), o(te, { files: a(e).attachmentIds, "onUpdate:files": t[12] || (t[12] = (l) => a(e).attachmentIds = l), limit: 1, multiple: false, "empty-text": "暂未上传附件", "show-download": "", showView: "", style: { margin: "10px 0", padding: "0" } }, null, 8, ["files"])]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible"]);
  };
} }, he = Y(ue, [["__scopeId", "data-v-83b22c4a"]]);
export {
  he as default
};
