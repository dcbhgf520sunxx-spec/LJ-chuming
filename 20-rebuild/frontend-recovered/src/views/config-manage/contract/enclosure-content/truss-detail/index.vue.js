import { ref as g } from "vue";
import { computed as K } from "vue";
import { watch as $ } from "vue";
import { resolveComponent as S } from "vue";
import { resolveDirective as Q } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as x } from "vue";
import { withDirectives as b } from "vue";
import { vShow as T } from "vue";
import { createElementVNode as h } from "vue";
import { createBlock as u } from "vue";
import { withCtx as r } from "vue";
import { createTextVNode as c } from "vue";
import { withModifiers as w } from "vue";
import { unref as o } from "vue";
import { Fragment as V } from "vue";
import { createVNode as k } from "vue";
import { toDisplayString as O } from "vue";
import { createCommentVNode as E } from "vue";
import { ElTableColumn as Y } from "element-plus";
import { ElInputNumber as G } from "element-plus";
import { vLoading as J } from "element-plus";
import { l as N, dn as W, dm as X, x as Z, o as ee, aw as te } from "../../../../../shared/runtime.js";
function ae(i) {
  return N({ module: "contract", url: "enclosure/dictionaries/dictDetail/all", method: "get", params: i });
}
function q(i) {
  return N({ module: "contract", url: `enclosure/dictionaries/dictDetailSave/type/${W.TRUSS_FLOOR_PLATE.V}`, method: "post", data: i });
}
const le = { get: ae, edit: q }, ne = { __name: "index", props: { line: { type: Object, default: () => {
} } }, setup(i, { expose: A }) {
  const y = X.detailInfo, C = g(), m = g(false), d = g(false), { crud: t, columns: D, CRUD: v } = Z({ title: "桁架楼层板", sort: [], permission: { ...y }, crudApi: { ...le }, queryOnPresenterCreated: false, hasPagination: false }, C), { maxHeight: I } = ee({ wrapperBox: ".truss-detail-card", extraHeight: 40 }), p = i, f = K(() => p.line && p.line.code), U = { label: [{ required: true, max: 20, message: "不能超过50个字符", trigger: "blur", type: "number" }] }, { tableValidate: B, wrongCellMask: H } = te({ rules: U });
  $(() => f, (s) => {
    s.value && t.toQuery();
  }, { deep: true, immediate: true }), v.HOOK.beforeRefresh = () => (t.query.code = p.line.code, t.query.type = p.line.type, !!t.query.code), v.HOOK.handleRefresh = (s, e) => {
    e.data.content = e.data.content.map((a) => (a.label = a.label ? Number(a.label) : void 0, a));
  };
  function R() {
    m.value = false, d.value = false, t.refresh();
  }
  async function P() {
    const { validResult: s, dealList: e } = B(t.data);
    if (s) t.data = e;
    else return s;
    d.value = true;
    try {
      const a = { code: f.value, dictionaryDetails: t.data };
      await q(a), R(), t.notify("操作成功", v.NOTIFICATION_TYPE.SUCCESS);
    } catch (a) {
      console.log("修改桁架楼层板", a);
    }
  }
  return A({ permission: y, toAdd: t.toAdd }), (s, e) => {
    const a = S("common-button"), _ = Y, L = G, M = S("common-table"), z = Q("permission"), F = J;
    return l(), x("div", null, [b(h("div", null, e[1] || (e[1] = [h("div", { class: "my-code" }, "点击围护配置查看详情", -1)]), 512), [[T, !f.value]]), b(h("div", null, [m.value === false ? b((l(), u(a, { key: 0, class: "filter-item", size: "default", type: "primary", onClick: e[0] || (e[0] = w((n) => m.value = true, ["stop"])), disabled: d.value }, { default: r(() => e[2] || (e[2] = [c("修改")])), _: 1, __: [2] }, 8, ["disabled"])), [[z, o(y).edit]]) : (l(), x(V, { key: 1 }, [k(a, { class: "filter-item", size: "default", onClick: w(R, ["stop"]), disabled: d.value }, { default: r(() => e[3] || (e[3] = [c("取消")])), _: 1, __: [3] }, 8, ["disabled"]), k(a, { class: "filter-item", size: "default", type: "primary", onClick: w(P, ["stop"]), disabled: d.value }, { default: r(() => e[4] || (e[4] = [c("提交")])), _: 1, __: [4] }, 8, ["disabled"])], 64)), b((l(), u(M, { ref_key: "tableRef", ref: C, data: o(t).data, "empty-text": o(t).emptyText, "max-height": o(I), "cell-class-name": o(H), "return-source-data": "", showEmptySymbol: false, style: { width: "100%", "margin-top": "10px" } }, { default: r(() => [k(_, { label: "序号", type: "index", align: "center", width: "60" }), o(D).visible("remark") ? (l(), u(_, { key: "remark", prop: "remark", "show-overflow-tooltip": true, label: "名称" }, { default: r((n) => [c(O(n.row.remark), 1)]), _: 1 })) : E("", true), o(D).visible("label") ? (l(), u(_, { key: "label", prop: "label", label: "值" }, { default: r((n) => [m.value === true ? (l(), u(L, { key: 0, class: "align-left", modelValue: n.row.label, "onUpdate:modelValue": (j) => n.row.label = j, placeholder: "请填写", type: "text", "controls-position": "right", style: { width: "200px" }, min: 0 }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (l(), x(V, { key: 1 }, [c(O(n.row.label), 1)], 64))]), _: 1 })) : E("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "cell-class-name"])), [[F, o(t).loading]])], 512), [[T, f.value]])]);
  };
} };
export {
  ne as default
};
