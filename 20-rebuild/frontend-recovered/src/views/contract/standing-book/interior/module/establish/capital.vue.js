import { useStore as Z } from "vuex";
import { computed as I } from "vue";
import { ref as _ } from "vue";
import { watchEffect as ee } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as v } from "vue";
import { createVNode as t } from "vue";
import { withCtx as l } from "vue";
import { unref as s } from "vue";
import { createBlock as j } from "vue";
import { createTextVNode as V } from "vue";
import { createCommentVNode as ae } from "vue";
import { createElementVNode as p } from "vue";
import { Fragment as x } from "vue";
import { renderList as D } from "vue";
import { toDisplayString as N } from "vue";
import { ElTag as te } from "element-plus";
import { ElButton as le } from "element-plus";
import { ElCol as oe } from "element-plus";
import { ElDatePicker as ne } from "element-plus";
import { ElFormItem as se } from "element-plus";
import { ElRow as re } from "element-plus";
import { ElOption as pe } from "element-plus";
import { ElSelect as de } from "element-plus";
import { ElInput as ie } from "element-plus";
import { ElForm as ue } from "element-plus";
import { ElDivider as ce } from "element-plus";
import { ElDrawer as me } from "element-plus";
import { _ as fe, ao as _e, ia as ye, dp as be, fv as ge, cy as Ie, b as ve, j1 as w, dq as je, e2 as Ve, e6 as F, R as we } from "../../../../../../shared/runtime.js";
import { c as ke } from "../../../../../../modules/data-039b7fd9.js";
import { a as Se, b as Te } from "../../../../../../modules/capital-de0d42db.js";
const Ee = { class: "collection-container" }, Be = { style: { float: "left" } }, Ce = { style: { float: "right", color: "var(--el-text-color-secondary)", "font-size": "13px" } }, Me = { __name: "capital", props: { visible: { type: Boolean }, id: { type: [String, Number] } }, emits: ["update:visible"], setup(A, { expose: L, emit: R }) {
  const O = A, z = R, k = Z(), h = I(() => k.getters.user.id), S = _(null), T = _([]), y = _(false), c = _([]), E = { attachmentId: [], assetInjectionTime: (/* @__PURE__ */ new Date()).getTime(), creatorUserId: h.value ?? null };
  function P() {
    E.assetInjectionTime = (/* @__PURE__ */ new Date()).getTime();
  }
  const { crud: b, form: a } = _e(E), B = I(() => a != null && a.amount ? ye(a.amount) : ""), q = async () => {
    if (!ve(a.projectId)) try {
      const n = await Se(a.projectId);
      c.value = Object.entries(n).map(([e, m]) => {
        const [f, r] = Object.entries(m)[0];
        return { id: f, label: r, key: e };
      });
    } catch (n) {
      console.error("获取注资对象报错", n);
    }
  };
  (async () => {
    try {
      const { content: n } = await Te();
      T.value = n;
    } catch (n) {
      console.error("获取注资类型失败", n);
    }
  })();
  const Q = async (n) => {
    try {
      const e = await w.get(`/api/contract/Injection/getPutAssetInjection/${n}`);
      typeof e.assetInjectionEnum == "string" && (e.assetInjectionEnum = Number(e.assetInjectionEnum)), e.capitalType = e.projectManagerScale ? "projectManagerId" : "contractSignBodyId", e.amount = e.projectManagerScale || e.contractSignBodyScale, e.creatorUserId = e.user.id || null, Object.assign(a, e);
    } catch (e) {
      console.error("注资回显示失败", e);
    }
  };
  ee(() => {
    if (a.capitalType && a.amount) switch (a.capitalType) {
      case "contractSignBodyId":
        a.contractSignBodyScale = a.amount, a.contractSignBodyId = Number(c.value.find((n) => n.key === "contractSignBodyId").id), delete a.projectManagerScale, delete a.projectManagerId;
        break;
      case "projectManagerId":
        delete a.contractSignBodyScale, delete a.contractSignBodyId, a.projectManagerScale = a.amount, a.projectManagerId = Number(c.value.find((n) => n.key === "projectManagerId").id);
        break;
    }
  });
  const $ = async () => {
    S.value.validate().then(async () => {
      var n;
      try {
        y.value = true;
        const e = je(a);
        (n = e == null ? void 0 : e.attachment) != null && n.length && (e.attachmentId = e.attachment.map((m) => m.id)), a.id ? await w.put("/api/contract/Injection", e) : await w.post("/api/contract/Injection", e), await Ve("success", "提交成功"), F(a, { sustainable: ["assetInjectionTime"] }), await b.toQuery(), await b.crudApi.getAmount(), await k.dispatch("approval_list/fetchApprovalNum"), C();
      } catch {
        console.error("提交失败：saveInvoice");
      } finally {
        y.value = false;
      }
    });
  }, C = () => {
    a != null && a.attachment && (a.attachment = []), F(a, { sustainable: ["assetInjectionTime"] }), z("update:visible", false);
  }, H = (n) => {
    n.length > 1 && (a.attachment = [n[n.length - 1]]);
  }, G = I(() => !(a != null && a.projectId));
  return L({ getCapitalItemInfo: Q }), (n, e) => {
    const m = te, f = le, r = oe, J = ne, i = se, d = re, M = pe, U = de, g = ie, K = ue, W = ce, X = we, Y = me;
    return u(), v("div", Ee, [t(Y, { "close-on-click-modal": false, "close-on-press-escape": false, "model-value": O.visible, "show-close": false, "append-to-body": "", "destroy-on-close": "", size: "40%", onOpened: P }, { header: l(() => [t(be, { "header-title": s(a).id ? "注资编辑" : "注资创建", "type-one": false }, { subTitle: l(() => [G.value ? (u(), j(m, { key: 0, size: "default", type: "danger" }, { default: l(() => e[9] || (e[9] = [V("请先进行项目选择!")])), _: 1, __: [9] })) : ae("", true)]), _: 1 }, 8, ["header-title"]), t(f, { plain: "", onClick: C }, { default: l(() => e[10] || (e[10] = [V("关闭")])), _: 1, __: [10] }), t(f, { loading: y.value, type: "success", onClick: $ }, { default: l(() => e[11] || (e[11] = [V("提交")])), _: 1, __: [11] }, 8, ["loading"])]), default: l(() => [t(K, { ref_key: "formRef", ref: S, model: s(a), rules: s(ke), class: "form-container", "label-position": "left" }, { default: l(() => [t(d, null, { default: l(() => [t(r, { span: 4 }, { default: l(() => e[12] || (e[12] = [p("span", { class: "prop-span label" }, "注资日期：", -1)])), _: 1, __: [12] }), t(r, { span: 20 }, { default: l(() => [t(i, { prop: "assetInjectionTime" }, { default: l(() => [t(J, { modelValue: s(a).assetInjectionTime, "onUpdate:modelValue": e[0] || (e[0] = (o) => s(a).assetInjectionTime = o), clearable: "", placeholder: "请选择日期", "prefix-icon": "", style: { width: "100%" }, type: "date", "value-format": "x" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), t(d, null, { default: l(() => [t(r, { span: 4 }, { default: l(() => e[13] || (e[13] = [p("span", { class: "prop-span label" }, "项目：", -1)])), _: 1, __: [13] }), t(r, { span: 20 }, { default: l(() => [t(i, { prop: "projectId" }, { default: l(() => [t(ge, { modelValue: s(a).projectId, "onUpdate:modelValue": e[1] || (e[1] = (o) => s(a).projectId = o), projectManagerId: s(b).query.projectManagerId, class: "filter-item", clearable: "", onChange: q }, null, 8, ["modelValue", "projectManagerId"])]), _: 1 })]), _: 1 })]), _: 1 }), t(d, null, { default: l(() => [t(r, { span: 4 }, { default: l(() => e[14] || (e[14] = [p("span", { class: "prop-span label" }, "注资人：", -1)])), _: 1, __: [14] }), t(r, { span: 20 }, { default: l(() => [t(i, { prop: "capitalType" }, { default: l(() => [t(U, { modelValue: s(a).capitalType, "onUpdate:modelValue": e[2] || (e[2] = (o) => s(a).capitalType = o), modelModifiers: { number: true }, disabled: !c.value.length, clearable: "" }, { default: l(() => [(u(true), v(x, null, D(c.value, (o) => (u(), j(M, { key: o.key, label: o.label, value: o.key }, { default: l(() => [p("span", Be, N(o.label), 1), p("span", Ce, N(o.key === "contractSignBodyId" ? "签约主体" : "项目经理"), 1)]), _: 2 }, 1032, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue", "disabled"])]), _: 1 })]), _: 1 })]), _: 1 }), t(d, null, { default: l(() => [t(r, { span: 4 }, { default: l(() => e[15] || (e[15] = [p("span", { class: "prop-span label" }, "注资金额：", -1)])), _: 1, __: [15] }), t(r, { span: 20 }, { default: l(() => [t(i, { prop: "amount" }, { default: l(() => [t(g, { modelValue: s(a).amount, "onUpdate:modelValue": e[3] || (e[3] = (o) => s(a).amount = o), modelModifiers: { number: true }, clearable: "", placeholder: "请输入金额", type: "number" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), t(d, null, { default: l(() => [t(r, { span: 4 }, { default: l(() => e[16] || (e[16] = [p("span", { class: "label" }, "大写：", -1)])), _: 1, __: [16] }), t(r, { span: 20 }, { default: l(() => [t(g, { modelValue: B.value, "onUpdate:modelValue": e[4] || (e[4] = (o) => B.value = o), placeholder: "输入注资金额", readonly: "" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }), t(d, null, { default: l(() => [t(r, { span: 4 }, { default: l(() => e[17] || (e[17] = [p("span", { class: "prop-span label" }, "注资类型：", -1)])), _: 1, __: [17] }), t(r, { span: 20 }, { default: l(() => [t(i, { prop: "assetInjectionEnum" }, { default: l(() => [t(U, { modelValue: s(a).assetInjectionEnum, "onUpdate:modelValue": e[5] || (e[5] = (o) => s(a).assetInjectionEnum = o), modelModifiers: { number: true }, clearable: "", placeholder: "请选择注资类型" }, { default: l(() => [(u(true), v(x, null, D(T.value, (o) => (u(), j(M, { key: o.id, label: o.label, value: o.id }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), t(d, null, { default: l(() => [t(r, { span: 4 }, { default: l(() => e[18] || (e[18] = [p("span", { class: "prop-span label" }, "收款银行：", -1)])), _: 1, __: [18] }), t(r, { span: 20 }, { default: l(() => [t(i, { prop: "collectionDepositBank" }, { default: l(() => [t(g, { modelValue: s(a).collectionDepositBank, "onUpdate:modelValue": e[6] || (e[6] = (o) => s(a).collectionDepositBank = o), clearable: "", placeholder: "请输入收款银行" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), t(d, null, { default: l(() => [t(r, { span: 4 }, { default: l(() => e[19] || (e[19] = [p("span", { class: "prop-span label" }, "创建人：", -1)])), _: 1, __: [19] }), t(r, { span: 20 }, { default: l(() => [t(i, { prop: "creatorUserId" }, { default: l(() => [t(Ie, { modelValue: s(a).creatorUserId, "onUpdate:modelValue": e[7] || (e[7] = (o) => s(a).creatorUserId = o), "collapse-tags": false, class: "input-underline", clearable: "", filterable: "", placeholder: "请选择或输入创建人", style: { width: "100%" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 })]), _: 1 }, 8, ["model", "rules"]), t(W, null, { default: l(() => e[20] || (e[20] = [p("span", { class: "title" }, "附件", -1)])), _: 1, __: [20] }), t(X, { files: s(a).attachment, "onUpdate:files": [e[8] || (e[8] = (o) => s(a).attachment = o), H], "empty-text": "暂未上传附件", "show-download": "", showView: "", style: { "margin-top": "10px", "": "10px", padding: "0" } }, null, 8, ["files"])]), _: 1 }, 8, ["model-value"])]);
  };
} }, Ae = fe(Me, [["__scopeId", "data-v-3b759701"]]);
export {
  Ae as default
};
