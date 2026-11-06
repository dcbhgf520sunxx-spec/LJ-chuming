import { computed as k } from "vue";
import { ref as E } from "vue";
import { useStore as te } from "vuex";
import le from "moment";
import { watch as oe } from "vue";
import { resolveComponent as B } from "vue";
import { resolveDirective as q } from "vue";
import { openBlock as d } from "vue";
import { createBlock as w } from "vue";
import { withCtx as s } from "vue";
import { createVNode as l } from "vue";
import { unref as e } from "vue";
import { createTextVNode as b } from "vue";
import { withDirectives as g } from "vue";
import { createElementVNode as o } from "vue";
import { createElementBlock as f } from "vue";
import { toDisplayString as i } from "vue";
import { createCommentVNode as C } from "vue";
import { ElFormItem as ae } from "element-plus";
import { ElDatePicker as ne } from "element-plus";
import { ElCheckbox as se } from "element-plus";
import { ElInputNumber as re } from "element-plus";
import { ElTableColumn as ue } from "element-plus";
import { ElInput as ie } from "element-plus";
import { ElForm as de } from "element-plus";
import { vLoading as ce } from "element-plus";
import { g as me } from "../../../../../modules/settlement-manage-aa83dffa.js";
import { _ as pe, t as _e, m as ve, g8 as fe, ao as be, gt as ge, bN as he, z as Ae, cy as ye, iD as x, bD as Ve, ia as A, b as z, bV as we, R as Ie, S as Te, kD as Ne } from "../../../../../shared/runtime.js";
import { _ as Se } from "../../../../../modules/project-visa-select-e1b3658e.js";
const ke = { class: "rule-row" }, Ee = { key: 0, class: "project-name" }, Ce = { class: "rule-row" }, xe = { class: "rule-row" }, De = { class: "rule-row" }, Oe = { class: "rule-row" }, Re = { key: 0 }, je = { class: "rule-row" }, Ue = { class: "rule-row" }, Fe = { key: 0 }, Pe = { key: 1 }, Be = { key: 0 }, qe = { key: 0 }, ze = { key: 1 }, Le = { class: "rule-row" }, Ye = { class: "rule-row" }, Ge = { class: "rule-row" }, He = { class: "rule-row" }, Me = { key: 0 }, Ke = { key: 1 }, $e = { class: "item-center" }, We = { __name: "form", setup(Je) {
  var U;
  const { decimalPrecision: m } = _e(), { user: I } = ve("user"), T = k(() => p.status.edit > 0), D = k(() => (t.settlementAmount || 0) - (a.value.collectionAmount || 0)), N = k(() => (t.settlementAmount || 0) - (a.value.invoiceAmount || 0)), O = E(), a = E({}), y = E(false), L = te(), Y = { projectId: void 0, visaAmount: void 0, settlementDate: le().startOf("day").valueOf(), settlementAmount: void 0, processingSettlementAmount: void 0, breachAmount: void 0, remark: "", userId: (U = I == null ? void 0 : I.value) == null ? void 0 : U.id }, G = fe(["margin_type"]), { crud: p, form: t, CRUD: _ } = be(Y, O), { detail: v } = ge();
  oe([() => t == null ? void 0 : t.breachAmount, () => t == null ? void 0 : t.processingSettlementAmount, () => t == null ? void 0 : t.visaAmount], () => {
    t.settlementAmount = (t.processingSettlementAmount || 0) + (t.visaAmount || 0) - (t.breachAmount || 0);
  });
  const R = { projectId: [{ required: true, message: "请选择项目", trigger: "change" }], settlementDate: [{ required: true, message: "请选择结算日期", trigger: "change" }], userId: [{ required: true, message: "请选择申请人", trigger: "change" }], breachAmount: [{ required: false, message: "请输入违约金", trigger: "blur" }], settlementAmount: [{ required: true, message: "请输入最终结算额", trigger: "blur" }], processingSettlementAmount: [{ required: true, message: "请输入加工结算额", trigger: "blur" }], visaAmount: [{ required: true, message: "请输入签证额", trigger: "blur" }] };
  _.HOOK.beforeDetailLoaded = async (c) => {
    try {
      console.log(v), v.files = v.attachments || [];
    } catch {
      c.notify("获取结算单详情失败", _.NOTIFICATION_TYPE.ERROR);
    }
  }, _.HOOK.beforeEditDetailLoaded = async (c) => {
    console.log(t), t.projectId = t.project.id, v.files = t.attachments || [], y.value = !!t.breachAmount, j(t.projectId);
  }, _.HOOK.beforeToAdd = async (c) => {
    y.value = false, a.value = {};
  }, _.HOOK.afterAddSuccess = async () => {
    L.dispatch("project/fetchUserVisaProjects", { businessType: he.MACHINING.V });
  };
  function H(c) {
    R.breachAmount[0].required = c, c || (t.breachAmount = void 0);
  }
  async function j(c) {
    a.value = {};
    try {
      c && (a.value = await me(c), T.value || (t.visaAmount = a.value.visaAmount));
    } catch {
      p.notify("获取项目详情失败", _.NOTIFICATION_TYPE.ERROR);
    }
  }
  async function M(c) {
    try {
      const n = { id: v.id };
      if (c) {
        if (!v.files.length) {
          p.notify("请上传确签附件", _.NOTIFICATION_TYPE.WARNING);
          return;
        }
        t.attachmentIds = v.files.map((S) => S.id);
      } else n.status = Ne.REFUSE.V;
      p.submitCU();
    } catch {
      p.notify("提交结算单确签信息", _.NOTIFICATION_TYPE.ERROR);
    }
  }
  return (c, n) => {
    const S = B("common-button"), u = ae, K = ne, $ = se, V = re, W = ue, J = ie, Q = de, X = B("common-drawer"), Z = q("parse-time"), h = q("thousand"), ee = ce;
    return d(), w(X, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(p).cancelCU, visible: e(p).status.cu > 0, title: `${T.value ? "编辑" : "新增"}结算单`, "show-close": true, size: "50%" }, { titleRight: s(() => [l(S, { loading: e(p).status.cu === e(_).STATUS.PROCESSING, size: "default", type: "primary", onClick: M }, { default: s(() => n[10] || (n[10] = [b("提 交")])), _: 1, __: [10] }, 8, ["loading"])]), content: s(() => [g((d(), w(Q, { disabled: e(p).status.cu === e(_).STATUS.PROCESSING, ref_key: "formRef", ref: O, model: e(t), rules: R, size: "default", "label-width": "100px", class: "demo-form" }, { default: s(() => [o("div", ke, [l(u, { label: "项目", prop: "projectId" }, { default: s(() => [T.value ? (d(), f("span", Ee, i(e(Ae)(e(t).project)), 1)) : (d(), w(e(Se), { key: 1, modelValue: e(t).projectId, "onUpdate:modelValue": n[0] || (n[0] = (r) => e(t).projectId = r), clearable: "", filterSettlement: "", class: "input-underline", style: { width: "100%" }, onChange: j }, null, 8, ["modelValue"]))]), _: 1 })]), o("div", Ce, [l(u, { label: "合同内容", prop: "projectContentName" }, { default: s(() => [o("div", null, i(a.value.projectContentName), 1)]), _: 1 })]), o("div", xe, [l(u, { label: "结算日期", prop: "settlementDate" }, { default: s(() => [l(K, { modelValue: e(t).settlementDate, "onUpdate:modelValue": n[1] || (n[1] = (r) => e(t).settlementDate = r), type: "date", class: "input-underline", "value-format": "x", style: { width: "100%" }, placeholder: "请选择结算日期" }, null, 8, ["modelValue"])]), _: 1 }), l(u, { label: "申请人", prop: "userId" }, { default: s(() => [l(ye, { modelValue: e(t).userId, "onUpdate:modelValue": n[2] || (n[2] = (r) => e(t).userId = r), filterable: "", "collapse-tags": false, clearable: "", "show-all-levels": "", class: "input-underline", placeholder: "请选择申请人" }, null, 8, ["modelValue"])]), _: 1 })]), o("div", De, [l(u, { label: "签约单位", prop: "contractSignBodyName" }, { default: s(() => [o("div", null, i(a.value.contractSignBodyName), 1)]), _: 1 }), l(u, { label: "发包单位", prop: "customerUnit" }, { default: s(() => [o("div", null, i(a.value.customerUnit), 1)]), _: 1 })]), o("div", Oe, [l(u, { label: "签约人", prop: "signerName" }, { default: s(() => [o("div", null, i(a.value.signerName), 1)]), _: 1 }), l(u, { label: "合同含税", prop: "isTax" }, { default: s(() => {
      var r, F, P;
      return [o("div", null, [o("span", null, i((F = (r = e(x).V) == null ? void 0 : r[a.value.isTax]) == null ? void 0 : F.SL), 1), a.value.isTax === e(x).YES.V ? (d(), f("span", Re, "【" + i((P = e(Ve).VL) == null ? void 0 : P[a.value.invoiceType]) + " " + i(a.value.taxRate || 0) + "%】", 1)) : C("", true)])];
    }), _: 1 })]), o("div", je, [l(u, { label: "签订日期", prop: "signingDate" }, { default: s(() => [g(o("div", null, null, 512), [[Z, { val: a.value.signingDate, fmt: "{y}-{m}-{d}" }]])]), _: 1 }), l(u, { label: "合同额", prop: "contractAmount" }, { default: s(() => [o("div", null, [g(o("span", null, null, 512), [[h, { val: a.value.contractAmount || 0, dp: e(m).contract }]]), b("（" + i(e(A)(a.value.contractAmount || 0)) + "） ", 1)])]), _: 1 })]), o("div", Ue, [l(u, { label: "保证金额", prop: "marginAmount" }, { default: s(() => [e(z)(a.value.marginAmount) ? (d(), f("div", Fe, "无")) : (d(), f("div", Pe, [g(o("span", null, null, 512), [[h, { val: a.value.marginAmount || 0, dp: e(m).contract }]]), a.value.marginType ? (d(), f("span", Be, "（" + i(e(G).label.margin_type[a.value.marginType]) + "）", 1)) : C("", true)]))]), _: 1 }), l(u, { label: "累计发运额", prop: "happenedAmount" }, { default: s(() => [e(z)(a.value.happenedAmount) ? (d(), f("div", qe, "无")) : (d(), f("div", ze, [g(o("span", null, null, 512), [[h, { val: a.value.happenedAmount || 0, dp: e(m).contract }]]), b(" （" + i(e(A)(a.value.happenedAmount || 0)) + "） ", 1)]))]), _: 1 })]), o("div", Le, [l(u, { label: "违约金额", prop: "breachAmount" }, { default: s(() => [l($, { modelValue: y.value, "onUpdate:modelValue": n[3] || (n[3] = (r) => y.value = r), size: "default", onChange: H }, { default: s(() => n[11] || (n[11] = [b("有")])), _: 1, __: [11] }, 8, ["modelValue"]), y.value ? (d(), w(V, { key: 0, modelValue: e(t).breachAmount, "onUpdate:modelValue": n[4] || (n[4] = (r) => e(t).breachAmount = r), modelModifiers: { number: true }, min: 0.01, max: 99999999999, step: 1e3, precision: e(m).contract, class: "input-underline", placeholder: "请输入违约金额", controls: false, style: { width: "calc(100% - 40px)" } }, null, 8, ["modelValue", "precision"])) : C("", true)]), _: 1 }), l(u, { label: "签证额", prop: "visaAmount" }, { default: s(() => [l(V, { modelValue: e(t).visaAmount, "onUpdate:modelValue": n[5] || (n[5] = (r) => e(t).visaAmount = r), modelModifiers: { number: true }, min: 0, max: 99999999999, step: 1e3, precision: e(m).contract, class: "input-underline", placeholder: "请输入签证额", controls: false, style: { width: "100%" } }, null, 8, ["modelValue", "precision"])]), _: 1 })]), o("div", Ye, [l(u, { label: "加工结算额", prop: "processingSettlementAmount" }, { default: s(() => [l(V, { modelValue: e(t).processingSettlementAmount, "onUpdate:modelValue": n[6] || (n[6] = (r) => e(t).processingSettlementAmount = r), modelModifiers: { number: true }, min: 0, max: 99999999999, step: 1e3, precision: e(m).contract, class: "input-underline", placeholder: "请输入加工结算额", controls: false, style: { width: "100%" } }, null, 8, ["modelValue", "precision"])]), _: 1 }), l(u, { label: "最终结算额", prop: "settlementAmount" }, { default: s(() => [l(V, { modelValue: e(t).settlementAmount, "onUpdate:modelValue": n[7] || (n[7] = (r) => e(t).settlementAmount = r), modelModifiers: { number: true }, min: 0, max: 99999999999, step: 1e3, precision: e(m).contract, class: "input-underline", placeholder: "请输入最终结算额", controls: false, style: { width: "100%" } }, null, 8, ["modelValue", "precision"])]), _: 1 })]), o("div", Ge, [l(u, { label: "累计收款", prop: "collectionAmount" }, { default: s(() => [o("div", null, [g(o("span", null, null, 512), [[h, { val: a.value.collectionAmount || 0, dp: e(m).contract }]]), b("（" + i(e(A)(a.value.collectionAmount || 0)) + "） ", 1)])]), _: 1 }), l(u, { label: "结算应收", prop: "receivable" }, { default: s(() => [o("div", null, [g(o("span", null, null, 512), [[h, { val: D.value || 0, dp: e(m).contract }]]), b(" （" + i(e(A)(D.value || 0)) + "） ", 1)])]), _: 1 })]), o("div", He, [l(u, { label: "累计开票", prop: "invoiceAmount" }, { default: s(() => [o("div", null, [g(o("span", null, null, 512), [[h, { val: a.value.invoiceAmount || 0, dp: e(m).contract }]]), b("（" + i(e(A)(a.value.invoiceAmount || 0)) + "） ", 1)])]), _: 1 }), l(u, { label: "应补发票", prop: "debitInvoice" }, { default: s(() => [a.value.isTax === e(x).YES.V ? (d(), f("div", Me, [o("span", null, i(N.value ? e(we)(N.value, e(m).contract) : 0), 1), b(" （" + i(e(A)(N.value || 0)) + "） ", 1)])) : (d(), f("div", Ke, "无"))]), _: 1 })]), o("div", $e, [l(Ie, { accept: ".jpg,.png,.pdf,.jpeg", "file-classify": e(Te).CONTRACT_VISA.V, showView: "", showDownload: "", files: e(v).files, "onUpdate:files": n[8] || (n[8] = (r) => e(v).files = r), style: { "padding-bottom": "20px" } }, { applicant: s(() => [l(W, { label: "上传人", align: "center", "min-width": "60", "show-overflow-tooltip": true, prop: "createUserName" })]), _: 1 }, 8, ["file-classify", "files"]), l(J, { modelValue: e(t).remark, "onUpdate:modelValue": n[9] || (n[9] = (r) => e(t).remark = r), type: "textarea", autosize: { minRows: 2, maxRows: 4 }, placeholder: "请填写备注", maxlength: "200", "show-word-limit": "" }, null, 8, ["modelValue"])])]), _: 1 }, 8, ["disabled", "model"])), [[ee, e(p).editDetailLoading]])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, tt = pe(We, [["__scopeId", "data-v-89fbd976"]]);
export {
  tt as default
};
