import { ref as f } from "vue";
import { useStore as S } from "vuex";
import { watch as E } from "vue";
import { nextTick as N } from "vue";
import { resolveComponent as h } from "vue";
import { openBlock as q } from "vue";
import { createBlock as B } from "vue";
import { withCtx as o } from "vue";
import { createVNode as n } from "vue";
import { unref as a } from "vue";
import { createTextVNode as V } from "vue";
import { createElementVNode as _ } from "vue";
import { ElButton as O } from "element-plus";
import { ElDatePicker as P } from "element-plus";
import { ElFormItem as z } from "element-plus";
import { ElInput as A } from "element-plus";
import { ElForm as F } from "element-plus";
import { _ as K, ao as H, i as M, cy as G, jb as v, D as W, R as Y, iW as J, z as Q } from "../../../../../../shared/runtime.js";
import X from "../../components/supplier-select-sub/index.vue.js";
import Z from "../../components/invoice-type-select-private.vue.js";
import { a as $ } from "../../../../../../modules/index-dfff0f60.js";
import "../../components/supplier-select-sub/module/add-supplier.vue.js";
const ee = { class: "line-container" }, te = { class: "input-underline flex-rss child-mr-10" }, ae = { __name: "index", setup(le) {
  const x = f(), C = f(), w = { projectId: void 0, userId: S().getters.user.id, signDate: (/* @__PURE__ */ new Date()).getTime(), subcontractClassId: void 0, supplierId: void 0, branchCompanyId: void 0, amount: void 0, serialNumber: void 0, invoiceType: void 0, taxRateTypeValue: void 0, attachmentIds: void 0, remark: void 0 }, { crud: i, form: t, CRUD: b } = H(w, C), T = { projectId: [{ required: true, message: "请选择项目", trigger: ["change", "blur"] }], signDate: [{ required: true, message: "请选择日期", trigger: ["change", "blur"] }], userId: [{ required: true, message: "请选择创建人", trigger: ["change", "blur"] }], subcontractClassId: [{ required: true, message: "请选择分供类型", trigger: ["change", "blur"] }], supplierId: [{ required: true, message: "请选择供应商", trigger: ["change", "blur"] }], branchCompanyId: [{ required: true, message: "请选择签订主体", trigger: ["change", "blur"] }], amount: [{ required: true, message: "请输入合同额", trigger: ["change", "blur"] }], invoiceType: [{ required: true, message: "请选择发票类型", trigger: ["change", "blur"] }], taxRateTypeValue: [{ required: true, message: "请选择税率", trigger: ["change", "blur"] }] };
  E(() => t.branchCompanyId, (r) => {
    N(() => {
      M(t.projects) && (t.branchCompanyId = t.projects.contractSignBodyId);
    });
  }, { deep: true });
  function U(r) {
    var u;
    const e = v.VK[r];
    t.basicClass = ((u = J[e]) == null ? void 0 : u.V) || false;
  }
  const d = f([]);
  (async () => {
    var r;
    try {
      d.value = await $(), (r = d.value) == null || r.forEach((e) => {
        e.name = Q(e);
      });
    } catch (e) {
      console.log("获取项目失败", e);
    }
  })();
  const j = f(), g = f([]);
  function I(r) {
    var u, m, y, s, c;
    j.value = d.value.filter((p) => p.id === r)[0].level;
    const e = d.value.findIndex((p) => (p == null ? void 0 : p.id) === r);
    if (e !== -1) if ((u = d.value[e].branchCompanyList) != null && u.length && (g.value = d.value[e].branchCompanyList), Array.isArray((m = d.value[e]) == null ? void 0 : m.branchCompanyList) && ((y = d.value[e].branchCompanyList) == null ? void 0 : y.length) > 1) {
      t.branchCompanyId = void 0;
      return;
    } else ((s = d.value[e].branchCompanyList) == null ? void 0 : s.length) === 1 && (t.branchCompanyId = (c = d.value[e].branchCompanyList[0]) == null ? void 0 : c.id);
    else t.branchCompanyId = void 0;
  }
  return b.HOOK.beforeToAdd = () => {
    g.value = [];
  }, b.HOOK.beforeEditDetailLoaded = (r, e) => {
    var u, m;
    (u = e == null ? void 0 : e.project) != null && u.id && I(e.project.id), (m = e == null ? void 0 : e.branchCompany) != null && m.id && (t.branchCompanyId = e.branchCompany.id);
  }, b.HOOK.beforeSubmit = () => {
    var r;
    delete i.form.taxRate, (r = i.form.attachments) != null && r.length ? i.form.attachmentIds = i.form.attachments.map((e) => e.id) : i.form.attachmentIds = [];
  }, (r, e) => {
    const u = h("common-button"), m = O, y = P, s = z, c = h("common-select-v2"), p = A, k = h("common-input-number"), R = F, L = h("common-drawer");
    return q(), B(L, { ref_key: "drawerRef", ref: x, "show-close": false, title: a(i).status.title, visible: a(i).status.cu > 0, "destroy-on-close": "", size: "620px" }, { titleRight: o(() => [n(u, { loading: a(i).status.cu === a(b).STATUS.PROCESSING, size: "default", type: "success", onClick: a(i).submitCU }, { default: o(() => e[12] || (e[12] = [V(" 提交 ")])), _: 1, __: [12] }, 8, ["loading", "onClick"]), n(m, { plain: "", size: "default", onClick: a(i).cancelCU }, { default: o(() => e[13] || (e[13] = [V("关闭")])), _: 1, __: [13] }, 8, ["onClick"])]), content: o(() => [n(R, { ref_key: "formRef", ref: C, model: a(t), rules: T, "label-position": "right", "label-width": "110px", size: "default" }, { default: o(() => [n(s, { label: "日期", prop: "signDate" }, { default: o(() => [n(y, { modelValue: a(t).signDate, "onUpdate:modelValue": e[0] || (e[0] = (l) => a(t).signDate = l), class: "input-underline", clearable: "", placeholder: "日期", style: { width: "100%" }, type: "date", "value-format": "x" }, null, 8, ["modelValue"])]), _: 1 }), n(s, { label: "创建人", prop: "userId" }, { default: o(() => [n(G, { modelValue: a(t).userId, "onUpdate:modelValue": e[1] || (e[1] = (l) => a(t).userId = l), class: "input-underline", clearable: "", filterable: "", placeholder: "创建人" }, null, 8, ["modelValue"])]), _: 1 }), n(s, { label: "项目", prop: "projectId" }, { default: o(() => [n(c, { modelValue: a(t).projectId, "onUpdate:modelValue": e[2] || (e[2] = (l) => a(t).projectId = l), filterable: true, options: d.value, class: "input-underline", placeholder: "请选择项目", style: { width: "100%" }, onChange: I }, null, 8, ["modelValue", "options"])]), _: 1 }), n(s, { label: "分供类型", prop: "subcontractClassId" }, { default: o(() => [n(c, { modelValue: a(t).subcontractClassId, "onUpdate:modelValue": e[3] || (e[3] = (l) => a(t).subcontractClassId = l), filterable: true, options: a(v).ENUM, class: "input-underline", clearable: "", placeholder: "请选择分供类型", style: { width: "100%" }, type: "enum", onChange: U }, null, 8, ["modelValue", "options"])]), _: 1 }), n(s, { label: "分包商", prop: "supplierId" }, { default: o(() => [n(X, { modelValue: a(t).supplierId, "onUpdate:modelValue": e[4] || (e[4] = (l) => a(t).supplierId = l), basicClass: a(t).basicClass, disabled: !a(t).subcontractClassId, "is-sub-contract": true, class: "input-underline", clearable: "", filterable: "", mode: "contain", placeholder: "请选择分包商", style: { width: "100%" } }, null, 8, ["modelValue", "basicClass", "disabled"])]), _: 1 }), n(s, { label: "签约主体", prop: "branchCompanyId" }, { default: o(() => {
      var l;
      return [n(c, { modelValue: a(t).branchCompanyId, "onUpdate:modelValue": e[5] || (e[5] = (D) => a(t).branchCompanyId = D), dataStructure: { key: "id", label: "name", value: "id" }, disabled: !((l = g.value) != null && l.length), options: g.value, class: "input-underline", placeholder: "合同签订主体", style: { width: "100%" } }, null, 8, ["modelValue", "disabled", "options"])];
    }), _: 1 }), _("div", ee, [n(s, { label: "合同编号" }, { default: o(() => [n(p, { modelValue: a(t).serialNumber, "onUpdate:modelValue": e[6] || (e[6] = (l) => a(t).serialNumber = l), class: "input-underline", placeholder: "不填写则默认生成", style: { width: "100%" } }, null, 8, ["modelValue"])]), _: 1 }), n(s, { label: "合同额", prop: "amount", style: { display: "inline-flex", width: "100%" } }, { default: o(() => [_("div", te, [n(k, { modelValue: a(t).amount, "onUpdate:modelValue": e[7] || (e[7] = (l) => a(t).amount = l), controls: false, max: 999999999999, precision: a(W).YUAN, step: 1, autocomplete: "off", placeholder: "请填写合同额", style: { width: "100%" } }, null, 8, ["modelValue", "precision"]), e[14] || (e[14] = _("span", null, "元", -1))])]), _: 1 })]), n(s, { class: "el-form-item-10", label: "发票及税率", prop: "invoiceType" }, { default: o(() => [n(Z, { invoiceType: a(t).invoiceType, "onUpdate:invoiceType": e[8] || (e[8] = (l) => a(t).invoiceType = l), taxRateTypeValue: a(t).taxRateTypeValue, "onUpdate:taxRateTypeValue": e[9] || (e[9] = (l) => a(t).taxRateTypeValue = l), disabled: a(t).boolUsed, class: "input-underline" }, null, 8, ["invoiceType", "taxRateTypeValue", "disabled"])]), _: 1 }), n(p, { modelValue: a(t).remark, "onUpdate:modelValue": e[10] || (e[10] = (l) => a(t).remark = l), modelModifiers: { trim: true }, rows: 3, maxlength: "1000", placeholder: "备注信息", "show-word-limit": "", style: { width: "100%" }, type: "textarea" }, null, 8, ["modelValue"]), n(Y, { files: a(t).attachments, "onUpdate:files": e[11] || (e[11] = (l) => a(t).attachments = l), limit: 1, multiple: false, "empty-text": "暂未上传附件", "show-download": "", showView: "", style: { margin: "10px 0", padding: "0" } }, null, 8, ["files"])]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["title", "visible"]);
  };
} }, me = K(ae, [["__scopeId", "data-v-d9ab1b0f"]]);
export {
  me as default
};
