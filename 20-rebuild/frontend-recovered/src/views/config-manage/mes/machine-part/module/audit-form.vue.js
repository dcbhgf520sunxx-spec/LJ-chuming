import { ref as p } from "vue";
import { resolveComponent as y } from "vue";
import { openBlock as a } from "vue";
import { createBlock as f } from "vue";
import { withCtx as d } from "vue";
import { createVNode as l } from "vue";
import { unref as o } from "vue";
import { createTextVNode as B } from "vue";
import { createElementVNode as T } from "vue";
import { createElementBlock as i } from "vue";
import { toDisplayString as r } from "vue";
import { Fragment as H } from "vue";
import { createCommentVNode as D } from "vue";
import { isRef as M } from "vue";
import { ElNotification as U } from "element-plus";
import { ElFormItem as q } from "element-plus";
import { ElTableColumn as J } from "element-plus";
import { ElForm as G } from "element-plus";
import { l as m, _ as K, u as Q, o as W, c3 as N, au as _, f3 as X, f8 as R } from "../../../../../shared/runtime.js";
import { _ as c } from "../../../../../modules/index-61ce89a1.js";
function Y(e) {
  return m({ module: "contract", url: "system/assemble-config", method: "get", params: e });
}
function Z(e) {
  return m({ module: "contract", url: "system/assemble-config", method: "post", data: e });
}
function ee(e) {
  return m({ module: "contract", url: "system/assemble-config", method: "put", data: e });
}
function te(e) {
  return m({ module: "contract", url: "system/assemble-config", method: "delete", data: e });
}
function oe(e) {
  return m({ module: "contract", url: "system/assemble-config/auditUpdate", method: "put", data: e });
}
const Ie = { get: Y, add: Z, edit: ee, del: te };
const ne = { class: "detail-header" }, ae = { key: 1 }, le = { key: 1 }, se = { key: 1 }, de = { key: 1 }, ie = { key: 0 }, re = { key: 1 }, ce = { key: 0 }, fe = { key: 1 }, me = { __name: "audit-form", props: { modelValue: { type: Boolean, require: true }, showType: { type: String, default: "detail" }, detailInfo: { type: Object, default: () => {
} } }, emits: ["success", "update:modelValue"], setup(e, { emit: z }) {
  const w = e, F = p(), x = p(), u = p(false), h = z, { visible: b, handleClose: S } = Q({ emit: h, props: w }), { maxHeight: L } = W({ extraBox: [".el-drawer__header", ".detail-header"], wrapperBox: [".el-drawer__body", ".table-form"], navbar: false, extraHeight: 120 }, () => x.value.loaded);
  async function k(v) {
    u.value = true;
    try {
      await oe({ id: w.detailInfo.lastChangeId, auditType: v, mesProductEnum: w.detailInfo.mesProductEnum }), U({ title: "审核成功", type: "success" }), h("success"), S();
    } catch (n) {
      console.log("提交失败", n);
    } finally {
      u.value = false;
    }
  }
  return (v, n) => {
    const V = y("common-button"), I = q, g = J, O = y("table-cell-tag"), j = y("common-table"), A = G, $ = y("common-drawer");
    return a(), f($, { ref_key: "drawerRef", ref: x, "append-to-body": "", modelValue: o(b), "onUpdate:modelValue": n[2] || (n[2] = (t) => M(b) ? b.value = t : null), "before-close": o(S), title: "部件特征定义审核", center: false, "close-on-click-modal": false, size: "800px" }, { titleRight: d(() => [l(V, { loading: u.value, type: "primary", size: "default", onClick: n[0] || (n[0] = (t) => k(o(N).PASS.V)) }, { default: d(() => n[3] || (n[3] = [B("通过")])), _: 1, __: [3] }, 8, ["loading"]), l(V, { loading: u.value, type: "warning", size: "default", onClick: n[1] || (n[1] = (t) => k(o(N).REJECT.V)) }, { default: d(() => n[4] || (n[4] = [B("驳回")])), _: 1, __: [4] }, 8, ["loading"])]), content: d(() => [l(A, { ref_key: "formRef", ref: F, size: "default", "label-width": "140px" }, { default: d(() => [T("div", ne, [l(I, { label: "是否型材", prop: "classifyIds" }, { default: d(() => {
      var t, s, C, E, P;
      return [((t = e.detailInfo) == null ? void 0 : t.boolSectionSteel) !== ((s = e.detailInfo) == null ? void 0 : s.newBoolSectionSteel) ? (a(), f(o(c), { key: 0, old: o(_).VL[e.detailInfo.boolSectionSteel], new: o(_).VL[e.detailInfo.newBoolSectionSteel] }, null, 8, ["old", "new"])) : (a(), i("span", ae, r(o(_).VL[e.detailInfo.boolSectionSteel]), 1)), n[5] || (n[5] = T("br", null, null, -1)), (C = e.detailInfo) != null && C.boolSectionSteel ? (a(), i(H, { key: 2 }, [o(X)((E = e.detailInfo) == null ? void 0 : E.classifyIds, (P = e.detailInfo) == null ? void 0 : P.newClassifyIds) ? (a(), i("span", le, r(e.detailInfo.classifyNames), 1)) : (a(), f(o(c), { key: 0, old: e.detailInfo.classifyNames, new: e.detailInfo.newClassifyNames }, null, 8, ["old", "new"]))], 64)) : D("", true)];
    }), _: 1, __: [5] }), l(I, { label: "代表部件类型", prop: "name" }, { default: d(() => {
      var t, s;
      return [((t = e.detailInfo) == null ? void 0 : t.name) !== ((s = e.detailInfo) == null ? void 0 : s.name) ? (a(), f(o(c), { key: 0, old: e.detailInfo.name, new: e.detailInfo.newName }, null, 8, ["old", "new"])) : (a(), i("span", se, r(e.detailInfo.name), 1))];
    }), _: 1 }), l(I, { label: "排序", prop: "sort" }, { default: d(() => {
      var t, s;
      return [((t = e.detailInfo) == null ? void 0 : t.sort) !== ((s = e.detailInfo) == null ? void 0 : s.sort) ? (a(), f(o(c), { key: 0, old: e.detailInfo.sort, new: e.detailInfo.newSort }, null, 8, ["old", "new"])) : (a(), i("span", de, r(e.detailInfo.sort), 1))];
    }), _: 1 })]), l(j, { ref: "detailRef", border: "", data: e.detailInfo.newAssembleSpecList, "max-height": o(L), style: { width: "100%", "margin-top": "10px" }, class: "table-form", "return-source-data": "", showEmptySymbol: false }, { default: d(() => [l(g, { label: "序号", type: "index", align: "center", width: "55" }), l(g, { key: "specPrefix", prop: "specPrefix", label: "部件规格前缀(大写字母或中文)", align: "center" }, { default: d((t) => {
      var s;
      return [l(O, { name: o(R).VL[t.row.changeType], color: (s = o(R).V[t.row.changeType]) == null ? void 0 : s.COLOR, offset: 15 }, null, 8, ["name", "color"]), t.row.specPrefix !== t.row.newSpecPrefix ? (a(), i("span", ie, [l(o(c), { old: t.row.specPrefix, new: t.row.newSpecPrefix }, null, 8, ["old", "new"])])) : (a(), i("span", re, r(t.row.specPrefix), 1))];
    }), _: 1 }), l(g, { key: "specIndex", prop: "specIndex", label: "索引", align: "center" }, { default: d((t) => [t.row.specIndex !== t.row.newSpecIndex ? (a(), i("span", ce, [l(o(c), { old: t.row.specIndex || "全部", new: t.row.newSpecIndex || "全部" }, null, 8, ["old", "new"])])) : (a(), i("span", fe, r(t.row.specIndex || "全部"), 1))]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 512)]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, ue = K(me, [["__scopeId", "data-v-9fe81bbf"]]), ge = Object.freeze(Object.defineProperty({ __proto__: null, default: ue }, Symbol.toStringTag, { value: "Module" }));
export {
  ue as a,
  ge as b,
  Ie as c
};
