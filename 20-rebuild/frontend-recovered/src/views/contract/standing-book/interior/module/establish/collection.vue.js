import { useRoute as Y } from "vue-router";
import { useStore as Z } from "vuex";
import { computed as B } from "vue";
import { ref as j } from "vue";
import { resolveDirective as ee } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as p } from "vue";
import { createVNode as l } from "vue";
import { withCtx as t } from "vue";
import { createBlock as A } from "vue";
import { createTextVNode as i } from "vue";
import { createCommentVNode as le } from "vue";
import { unref as n } from "vue";
import { withDirectives as f } from "vue";
import { Fragment as M } from "vue";
import { renderList as N } from "vue";
import { createElementVNode as te } from "vue";
import { ElTag as oe } from "element-plus";
import { ElButton as ae } from "element-plus";
import { ElCol as ne } from "element-plus";
import { ElDatePicker as se } from "element-plus";
import { ElFormItem as ue } from "element-plus";
import { ElRow as de } from "element-plus";
import { ElInput as pe } from "element-plus";
import { ElOption as ie } from "element-plus";
import { ElSelect as re } from "element-plus";
import { ElForm as ce } from "element-plus";
import { ElDivider as me } from "element-plus";
import { ElDrawer as fe } from "element-plus";
import { _ as _e, kU as be, ao as ye, ia as Ve, dp as ve, fv as ge, iv as ke, cy as we, kV as Ie, bV as De, dq as Ue, kW as Be, e2 as je, e6 as Ae, R as Ee } from "../../../../../../shared/runtime.js";
import { a as Ce } from "../../../../../../modules/data-039b7fd9.js";
const xe = { class: "collection-container" }, Se = { class: "prop-span label" }, Fe = { class: "prop-span label" }, Me = { class: "label" }, Ne = { class: "prop-span label" }, Re = { class: "label" }, Pe = { class: "prop-span label" }, Te = { class: "prop-span label" }, Oe = { class: "label" }, Le = { class: "prop-span label" }, he = { class: "label" }, qe = { class: "prop-span label" }, ze = { __name: "collection", props: { visible: { type: Boolean } }, emits: ["update:visible"], setup(R, { emit: P }) {
  const y = Y(), V = new be(), T = R, E = Z(), C = { accessoryId: [], collectionDate: (/* @__PURE__ */ new Date()).getTime(), projectId: void 0, writtenById: E.getters.user.id };
  function O() {
    C.collectionDate = (/* @__PURE__ */ new Date()).getTime();
  }
  const { crud: w, form: o } = ye(C), x = B(() => o != null && o.collectionAmount ? Ve(o.collectionAmount) : ""), L = B(() => V.get("bk_" + y.fullPath) || []), h = P, S = j(null), I = j(false), q = j([]), z = async (d) => {
    if (d) try {
      const e = await Ie({ projectId: o.projectId }), { projectName: b, projectAttribute: v, collectionUnit: s, projectManagerName: D, userId: c, paymentDepositBank: r, paymentUnit: _, collectionUnitId: g, collectionAmountSum: k } = e;
      Object.assign(o, { projectName: b, projectAttribute: v, collectionUnit: s, projectManagerName: D, writtenById: c, paymentDepositBank: r, paymentUnit: _, collectionUnitId: g, collectionAmountSum: De(k) });
    } catch (e) {
      console.error("获取收款列表失败" + e);
    }
  }, J = async () => {
    S.value.validate().then(async () => {
      var d;
      try {
        I.value = true;
        const e = Ue(o);
        (d = e == null ? void 0 : e.attachment) != null && d.length && (e.accessoryId = e.attachment.map((b) => b.id)), await Be(e), je("success", "填报成功"), Ae(o, { sustainable: ["collectionDate"] }), q.value = [], await w.toQuery(), await w.crudApi.getAmount(), await E.dispatch("approval_list/fetchApprovalNum"), F();
      } catch (e) {
        console.error("发起填报失败" + e);
      } finally {
        I.value = false;
      }
    });
  }, F = () => {
    o != null && o.attachment && (o.attachment = []), h("update:visible", false);
  }, Q = (d) => {
    d.length > 1 && (o.attachment = [d[d.length - 1]]);
  }, H = (d) => {
    let e = [];
    V.get("bk_" + y.fullPath) && (e = JSON.parse(JSON.stringify(V.get("bk_" + y.fullPath)))), e.findIndex((b) => b.label === d) < 0 && e.push({ label: d, value: d }), V.remove("bk_" + y.fullPath), V.set("bk_" + y.fullPath, e);
  }, K = B(() => !(o != null && o.projectId));
  return (d, e) => {
    const b = oe, v = ae, s = ne, D = se, c = ue, r = de, _ = pe, g = ie, k = re, W = ce, $ = me, G = Ee, X = fe, m = ee("ellipsis");
    return u(), p("div", xe, [l(X, { "close-on-click-modal": false, "close-on-press-escape": false, "model-value": T.visible, "show-close": false, "destroy-on-close": "", size: "40%", onOpened: O }, { header: t(() => [l(ve, { "type-one": false, "header-title": "收款填报" }, { subTitle: t(() => [K.value ? (u(), A(b, { key: 0, size: "default", type: "danger" }, { default: t(() => e[13] || (e[13] = [i("请先进行项目选择!")])), _: 1, __: [13] })) : le("", true)]), _: 1 }), l(v, { plain: "", onClick: F }, { default: t(() => e[14] || (e[14] = [i("关闭")])), _: 1, __: [14] }), l(v, { loading: I.value, type: "success", onClick: J }, { default: t(() => e[15] || (e[15] = [i("创建")])), _: 1, __: [15] }, 8, ["loading"])]), default: t(() => [l(W, { ref_key: "formRef", ref: S, model: n(o), rules: n(Ce), class: "form-container", "label-position": "left" }, { default: t(() => [l(r, null, { default: t(() => [l(s, { span: 4 }, { default: t(() => [f((u(), p("span", Se, e[16] || (e[16] = [i("收款日期：")]))), [[m]])]), _: 1 }), l(s, { span: 20 }, { default: t(() => [l(c, { prop: "collectionDate" }, { default: t(() => [l(D, { modelValue: n(o).collectionDate, "onUpdate:modelValue": e[0] || (e[0] = (a) => n(o).collectionDate = a), clearable: "", placeholder: "请选择日期", "prefix-icon": "", type: "date", "value-format": "x" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), l(r, null, { default: t(() => [l(s, { span: 4 }, { default: t(() => [f((u(), p("span", Fe, e[17] || (e[17] = [i("项目：")]))), [[m]])]), _: 1 }), l(s, { span: 20 }, { default: t(() => [l(c, { prop: "projectId" }, { default: t(() => {
      var a;
      return [l(ge, { modelValue: n(o).projectId, "onUpdate:modelValue": e[1] || (e[1] = (U) => n(o).projectId = U), projectManagerId: (a = n(w)) == null ? void 0 : a.query.projectManagerId, class: "filter-item", clearable: "", onChange: e[2] || (e[2] = (U) => z(U)) }, null, 8, ["modelValue", "projectManagerId"])];
    }), _: 1 })]), _: 1 })]), _: 1 }), l(r, null, { default: t(() => [l(s, { span: 4 }, { default: t(() => [f((u(), p("span", Me, e[18] || (e[18] = [i("累计已收款：")]))), [[m]])]), _: 1 }), l(s, { span: 20 }, { default: t(() => [l(_, { modelValue: n(o).collectionAmountSum, "onUpdate:modelValue": e[3] || (e[3] = (a) => n(o).collectionAmountSum = a), placeholder: "请先选择项目", readonly: "" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }), l(r, null, { default: t(() => [l(s, { span: 4 }, { default: t(() => [f((u(), p("span", Ne, e[19] || (e[19] = [i("本次收款：")]))), [[m]])]), _: 1 }), l(s, { span: 20 }, { default: t(() => [l(c, { prop: "collectionAmount" }, { default: t(() => [l(_, { modelValue: n(o).collectionAmount, "onUpdate:modelValue": e[4] || (e[4] = (a) => n(o).collectionAmount = a), modelModifiers: { number: true }, clearable: "", placeholder: "请输入金额", type: "number" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), l(r, null, { default: t(() => [l(s, { span: 4 }, { default: t(() => [f((u(), p("span", Re, e[20] || (e[20] = [i("大写：")]))), [[m]])]), _: 1 }), l(s, { span: 20 }, { default: t(() => [l(_, { modelValue: x.value, "onUpdate:modelValue": e[5] || (e[5] = (a) => x.value = a), placeholder: "输入本次收款", readonly: "" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }), l(r, null, { default: t(() => [l(s, { span: 4 }, { default: t(() => [f((u(), p("span", Pe, e[21] || (e[21] = [i("收款类型：")]))), [[m]])]), _: 1 }), l(s, { span: 20 }, { default: t(() => [l(c, { prop: "collectionMode" }, { default: t(() => [l(k, { modelValue: n(o).collectionMode, "onUpdate:modelValue": e[6] || (e[6] = (a) => n(o).collectionMode = a), clearable: "", placeholder: "请选择收款类型" }, { default: t(() => [(u(true), p(M, null, N(n(ke).V, (a) => (u(), A(g, { key: a.K, label: a.L, value: a.V }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), l(r, null, { default: t(() => [l(s, { span: 4 }, { default: t(() => [f((u(), p("span", Te, e[22] || (e[22] = [i("付款单位：")]))), [[m]])]), _: 1 }), l(s, { span: 20 }, { default: t(() => [l(c, { prop: "paymentUnit" }, { default: t(() => [l(_, { modelValue: n(o).paymentUnit, "onUpdate:modelValue": e[7] || (e[7] = (a) => n(o).paymentUnit = a), clearable: "", placeholder: "请输入付款单位" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), l(r, null, { default: t(() => [l(s, { span: 4 }, { default: t(() => [f((u(), p("span", Oe, e[23] || (e[23] = [i("付款银行：")]))), [[m]])]), _: 1 }), l(s, { span: 20 }, { default: t(() => [l(c, null, { default: t(() => [l(_, { modelValue: n(o).paymentDepositBank, "onUpdate:modelValue": e[8] || (e[8] = (a) => n(o).paymentDepositBank = a), clearable: "", placeholder: "请输入付款银行" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), l(r, null, { default: t(() => [l(s, { span: 4 }, { default: t(() => [f((u(), p("span", Le, e[24] || (e[24] = [i("收款银行：")]))), [[m]])]), _: 1 }), l(s, { span: 20 }, { default: t(() => [l(c, { prop: "collectionDepositBank" }, { default: t(() => [l(k, { modelValue: n(o).collectionDepositBank, "onUpdate:modelValue": e[9] || (e[9] = (a) => n(o).collectionDepositBank = a), filterable: "", "allow-create": "", placeholder: "收款银行", style: { width: "100%" }, onChange: H }, { default: t(() => [(u(true), p(M, null, N(L.value, (a) => (u(), A(g, { key: a.value, label: a.label, value: a.value }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), l(r, null, { default: t(() => [l(s, { span: 4 }, { default: t(() => [f((u(), p("span", he, e[25] || (e[25] = [i("收款单位：")]))), [[m]])]), _: 1 }), l(s, { span: 20 }, { default: t(() => [l(c, null, { default: t(() => [l(_, { modelValue: n(o).collectionUnit, "onUpdate:modelValue": e[10] || (e[10] = (a) => n(o).collectionUnit = a), clearable: "", placeholder: "收款单位" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), l(r, null, { default: t(() => [l(s, { span: 4 }, { default: t(() => [f((u(), p("span", qe, e[26] || (e[26] = [i("创建人：")]))), [[m]])]), _: 1 }), l(s, { span: 20 }, { default: t(() => [l(c, { prop: "writtenById" }, { default: t(() => [l(we, { modelValue: n(o).writtenById, "onUpdate:modelValue": e[11] || (e[11] = (a) => n(o).writtenById = a), "collapse-tags": false, class: "input-underline", clearable: "", filterable: "", placeholder: "请选择或输入创建人", style: { width: "100%" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 })]), _: 1 }, 8, ["model", "rules"]), l($, null, { default: t(() => e[27] || (e[27] = [te("span", { class: "title" }, "附件", -1)])), _: 1, __: [27] }), l(G, { files: n(o).attachment, "onUpdate:files": [e[12] || (e[12] = (a) => n(o).attachment = a), Q], "empty-text": "暂未上传附件", "show-download": "", showView: "", style: { "margin-top": "10px", "": "10px", padding: "0" } }, null, 8, ["files"])]), _: 1 }, 8, ["model-value"])]);
  };
} }, Ke = _e(ze, [["__scopeId", "data-v-4f859a2a"]]);
export {
  Ke as default
};
