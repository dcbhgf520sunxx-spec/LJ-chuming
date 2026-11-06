import { ref as r } from "vue";
import { onMounted as T } from "vue";
import { provide as B } from "vue";
import { resolveComponent as M } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as w } from "vue";
import { createElementVNode as c } from "vue";
import { createVNode as e } from "vue";
import { unref as l } from "vue";
import { createBlock as x } from "vue";
import { withCtx as p } from "vue";
import { createTextVNode as j } from "vue";
import { Fragment as H } from "vue";
import { withDirectives as k } from "vue";
import { vShow as S } from "vue";
import { toDisplayString as _ } from "vue";
import { ElTag as I } from "element-plus";
import { ElTableColumn as V } from "element-plus";
import { vLoading as z } from "element-plus";
import { c as F } from "../../../../modules/scheduling-manage-9a6dc016.js";
import { d as O } from "../../../../modules/enclosure-365a2177.js";
import { _ as U, x as $, o as G, P as J, mb as K } from "../../../../shared/runtime.js";
import W from "./project-list/index.vue.js";
import X from "./module/header-v2.vue.js";
import "./project-list/module/header.vue.js";
import "./module/collect.vue.js";
import "../../../../modules/use-scheduling-groups-b1c4e979.js";
const Y = { class: "wrap" }, Z = { class: "wrap-left" }, ee = { class: "wrap-right" }, te = { class: "app-container" }, ae = { __name: "index", setup(ne) {
  const C = { add: false, edit: false, del: false, download: false }, g = r(), L = r({}), f = r(), u = r([]), m = r([]), { crud: n } = $({ title: "排产管理", sort: [], permission: { ...O }, optShow: { ...C }, crudApi: { ...F }, queryOnPresenterCreated: false, props: { selectList: [] } }, g);
  n.page.size = 100;
  const { maxHeight: q } = G({ paginate: true });
  function D(a, i) {
    n.props.selectList = a.map((s) => ({ ...s, newQuantity: s.quantity - s.schedulingQuantity }));
  }
  function P(a) {
    n.props.selectList = a.map((i) => ({ ...i, newQuantity: i.quantity - i.schedulingQuantity }));
  }
  async function R() {
    try {
      const { content: a } = await K();
      m.value = a || [];
    } catch (a) {
      console.log(a);
    }
  }
  function Q(a = []) {
    setTimeout(() => {
      n.data = [], u.value = a;
    }, 300);
  }
  return T(() => {
    R();
  }), B("enclosureDictList", m), (a, i) => {
    var h, y, b, v;
    const s = I, t = V, A = M("common-table"), E = z;
    return d(), w("div", Y, [c("div", Z, [e(l(W), { ref_key: "projectListRef", ref: f, onProjectChange: Q }, null, 512)]), c("div", ee, [c("div", te, [(h = u.value) != null && h.length ? (d(), w(H, { key: 1 }, [e(X, { "area-ids": u.value, project: L.value, class: "head-container scheduling-head-container", onRefreshProject: (y = f.value) == null ? void 0 : y.refresh }, null, 8, ["area-ids", "project", "onRefreshProject"]), k((d(), x(A, { ref_key: "tableRef", ref: g, data: l(n).data, "empty-text": l(n).emptyText, "max-height": l(q), "row-key": "id", onSelect: D, onSelectAll: P }, { default: p(() => [e(t, { align: "center", type: "selection", width: "60" }), e(t, { align: "center", label: "序号", type: "index", width: "60" }), e(t, { align: "center", label: "单体/区域", "min-width": "120", prop: "planName", "show-overflow-tooltip": "" }), e(t, { align: "center", label: "类型" }, { default: p(({ row: o }) => [j(_(m.value.find((N) => N.id === o.dictionaryId).label), 1)]), _: 1 }), e(t, { align: "center", label: "编号", prop: "serialNumber" }), e(t, { align: "center", label: "名称", prop: "name" }), e(t, { align: "center", label: "规格", prop: "plate" }), e(t, { align: "center", label: "有效宽度", prop: "width" }), e(t, { align: "center", label: "厚度（mm）", "min-width": "120", prop: "thickness" }), e(t, { align: "center", label: "单长（mm）", "min-width": "120", prop: "length" }), e(t, { align: "center", label: "计量单位", prop: "unit" }), e(t, { align: "center", label: "数量", prop: "quantity" }, { default: p(({ row: o }) => [c("span", null, _(o.quantity - o.schedulingQuantity), 1)]), _: 1 }), e(t, { align: "center", label: "总长度(m)", prop: "" }, { default: p(({ row: o }) => [c("span", null, _((o.length * (o.quantity - o.schedulingQuantity) / 1e3).toFixed(2)), 1)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[S, (b = l(n).data) == null ? void 0 : b.length], [E, l(n).loading]]), k(e(l(J), null, null, 512), [[S, (v = l(n).data) == null ? void 0 : v.length]])], 64)) : (d(), x(s, { key: 0, effect: "plain", size: "large", type: "info" }, { default: p(() => i[0] || (i[0] = [j(" * 请点击左侧选项列表查看详情")])), _: 1, __: [0] }))])])]);
  };
} }, ge = U(ae, [["__scopeId", "data-v-07e95ef4"]]);
export {
  ge as default
};
