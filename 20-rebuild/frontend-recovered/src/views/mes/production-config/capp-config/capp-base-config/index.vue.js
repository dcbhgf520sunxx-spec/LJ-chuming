import { useStore as P } from "vuex";
import { ref as b } from "vue";
import { computed as $ } from "vue";
import { resolveComponent as M } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as O } from "vue";
import { createVNode as l } from "vue";
import { unref as t } from "vue";
import { createElementVNode as w } from "vue";
import { withCtx as p } from "vue";
import { createTextVNode as j } from "vue";
import { toDisplayString as B } from "vue";
import { withDirectives as z } from "vue";
import { createBlock as v } from "vue";
import { createCommentVNode as G } from "vue";
import { ElMessageBox as Q } from "element-plus";
import { ElTag as Y } from "element-plus";
import { ElTableColumn as J } from "element-plus";
import { ElSwitch as W } from "element-plus";
import { vLoading as X } from "element-plus";
import { _ as Z, x as ee, oD as h, oE as ae, o as te, V as le, b as x, i as k, G as D, aS as m, an as ne, oF as oe } from "../../../../../shared/runtime.js";
import re from "./module/header.vue.js";
import se from "./module/form.vue.js";
import ce from "./module/batch-form.vue.js";
import ie from "./module/capp-tree.vue.js";
import "../../../../../modules/use-table-operate-4f84437f.js";
const de = { class: "app-container" }, ue = { key: 1 }, pe = { __name: "index", setup(me) {
  const U = P(), V = b({}), C = b(), L = { batchAdd: false, add: false, edit: false, del: false, download: false }, { crud: a, CRUD: c } = ee({ title: "字典值", sort: [], permission: { ...h }, queryOnPresenterCreated: false, optShow: { ...L }, crudApi: { ...ae } }, C), { maxHeight: R } = te(), F = b(9999999999), A = b([["createTime", "parse-time"], ["updateTime", "parse-time"]]), H = $(() => {
    let n = le([...a.data]);
    return n = n.filter((e) => {
      var s, r, f, g, y, o, i, d, T, N, S, E, q;
      return (x((s = a.query) == null ? void 0 : s.enabledFlag) || k((r = a.query) == null ? void 0 : r.enabledFlag) && (e == null ? void 0 : e.enabledFlag) === ((f = a.query) == null ? void 0 : f.enabledFlag)) && (x((g = a.query) == null ? void 0 : g.dictValue) || k((y = a.query) == null ? void 0 : y.dictValue) && ((i = e == null ? void 0 : e.dictValue) == null ? void 0 : i.includes((o = a.query) == null ? void 0 : o.dictValue))) && (x((d = a.query) == null ? void 0 : d.userName) || k((T = a.query) == null ? void 0 : T.userName) && (((S = e == null ? void 0 : e.createUserName) == null ? void 0 : S.includes((N = a.query) == null ? void 0 : N.userName)) || ((q = e == null ? void 0 : e.updateUserName) == null ? void 0 : q.includes((E = a.query) == null ? void 0 : E.userName))));
    }), n.sort((e, s) => (e.sort || F.value) - (s.sort || F.value));
  });
  function I(n) {
    V.value = n, a.query.dictType = n.id, a.toQuery();
  }
  async function K(n, e) {
    try {
      await Q.confirm('此操作将 "' + m.VL[e] + '" ' + n.dictValue + ", 是否继续？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await oe({ id: n.id, enabledFlag: e }), a.refresh(), a.notify(m.VL[e] + "成功", c.NOTIFICATION_TYPE.SUCCESS), _();
    } catch (s) {
      console.log("修改状态失败", s), n.enabledFlag = !n.enabledFlag;
    }
  }
  function _() {
    U.commit("config/SET_LOADED", { key: "cappDict", loaded: false });
  }
  return c.HOOK.afterBatchSubmit = () => {
    _();
  }, c.HOOK.afterSubmit = () => {
    _();
  }, c.HOOK.afterDelete = () => {
    _();
  }, c.HOOK.handleRefresh = (n, { data: e }) => {
    e.content = e;
  }, (n, e) => {
    const s = Y, r = J, f = W, g = M("common-table"), y = X;
    return u(), O("div", de, [l(t(ie), { onChange: I }), w("div", null, [l(t(re), null, { name: p(() => [w("div", null, [l(s, { type: "primary", effect: "plain", size: "large" }, { default: p(() => {
      var o;
      return [j(B((o = V.value) == null ? void 0 : o.fullName), 1)];
    }), _: 1 })])]), _: 1 }), z((u(), v(g, { ref_key: "tableRef", ref: C, data: H.value, "empty-text": t(a).emptyText, "max-height": t(R), style: { width: "100%" }, "data-format": A.value, "row-key": "id" }, { default: p(() => [l(r, { label: "序号", type: "index", align: "center", width: "60" }), l(r, { key: "dictValue", prop: "dictValue", align: "center", label: "字典值" }), l(r, { key: "createUserName", prop: "createUserName", align: "center", label: "创建人" }), l(r, { key: "createTime", prop: "createTime", align: "center", label: "创建时间" }), l(r, { key: "updateUserName", prop: "updateUserName", align: "center", label: "编辑人" }), l(r, { key: "updateTime", prop: "updateTime", align: "center", label: "编辑日期" }), l(r, { key: "sort", prop: "sort", align: "center", label: "排序" }), l(r, { key: "enabledFlag", prop: "enabledFlag", label: "状态", align: "center" }, { default: p(({ row: o }) => {
      var i;
      return [t(D)(t(h).editStatus) ? (u(), v(f, { key: 0, modelValue: o.enabledFlag, "onUpdate:modelValue": (d) => o.enabledFlag = d, "active-color": "#409EFF", "inactive-color": "#F56C6C", "active-value": t(m).TRUE.V, "inactive-value": t(m).FALSE.V, onClick: (d) => K(o, o.enabledFlag) }, null, 8, ["modelValue", "onUpdate:modelValue", "active-value", "inactive-value", "onClick"])) : (u(), O("span", ue, B((i = t(m).VL) == null ? void 0 : i[o.enabledFlag]), 1))];
    }), _: 1 }), t(D)([...t(h).edit, ...t(h).del]) ? (u(), v(r, { key: 0, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: p((o) => [l(t(ne), { data: o.row }, null, 8, ["data"])]), _: 1 })) : G("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "data-format"])), [[y, t(a).loading]])]), l(t(se)), l(t(ce))]);
  };
} }, ke = Z(pe, [["__scopeId", "data-v-94800f7a"]]);
export {
  ke as default
};
