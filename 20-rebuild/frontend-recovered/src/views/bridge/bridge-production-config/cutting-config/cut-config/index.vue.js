import { ref as h } from "vue";
import { provide as J } from "vue";
import { inject as N } from "vue";
import { computed as P } from "vue";
import { watch as Q } from "vue";
import { resolveComponent as T } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as V } from "vue";
import { withDirectives as w } from "vue";
import { vShow as k } from "vue";
import { createElementVNode as y } from "vue";
import { createBlock as l } from "vue";
import { withCtx as C } from "vue";
import { createVNode as b } from "vue";
import { unref as e } from "vue";
import { createCommentVNode as m } from "vue";
import { ElTableColumn as j } from "element-plus";
import { vLoading as S } from "element-plus";
import { c as U } from "../../../../../modules/cutting-config-4fe0051a.js";
import { x as F, ax as s, G, an as L } from "../../../../../shared/runtime.js";
import M from "./module/form.vue.js";
const Y = { __name: "index", props: { layingOffRow: { type: Object, default: () => {
} } }, emits: ["click-cut-config"], setup(R, { expose: H, emit: q }) {
  const D = q, u = h(false), v = h(), f = h(), { crud: t, columns: p, CRUD: d } = F({ title: "切割方式配置", sort: [], permission: { ...s }, crudApi: { ...U }, queryOnPresenterCreated: false }, f);
  J("crud", t);
  const A = N("maxHeight"), c = R, n = P(() => c.layingOffRow && c.layingOffRow.id);
  Q(() => n, (i) => {
    i.value && (u.value = true, t.toQuery());
  }, { deep: true, immediate: true });
  function B(i) {
    v.value = i.id, console.log(i, "cutConfig-click"), D("click-cut-config", i);
  }
  function x(i) {
    var o;
    (o = f.value) == null || o.setCurrentRow(i);
  }
  d.HOOK.beforeRefresh = () => (t.query.id = n.value, !!t.query.id), d.HOOK.beforeToQuery = () => (t.query.id = n.value, !!t.query.id), d.HOOK.handleRefresh = (i, o) => {
    o.data.content = o.data.content.map((a, g) => (u.value && g === 0 && x(a), !u.value && v.value === a.id && x(a), a));
  }, d.HOOK.beforeSubmit = () => {
    t.form.layingWayId = n.value;
  };
  function E() {
    u.value = false, t.toQuery();
  }
  return H({ permission: s, refresh: E, toAdd: t.toAdd }), (i, o) => {
    const a = j, g = T("common-table"), K = S;
    return r(), V("div", null, [w(y("div", null, o[0] || (o[0] = [y("div", { class: "my-code" }, "点击下料方式查看详情", -1)]), 512), [[k, !n.value]]), w(y("div", null, [w((r(), l(g, { ref_key: "tableRef", ref: f, data: e(t).data, "highlight-current-row": "", "empty-text": e(t).emptyText, "max-height": e(A) + 92, style: { width: "100%" }, "row-key": "id", onCurrentChange: B }, { default: C(() => [b(a, { label: "序号", type: "index", align: "center", width: "60" }), e(p).visible("name") ? (r(), l(a, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "切割形式", align: "center", "min-width": "120px" })) : m("", true), e(p).visible("thickness") ? (r(), l(a, { key: "thickness", prop: "thickness", "show-overflow-tooltip": true, label: "支持板厚(mm) ≤", align: "center", "min-width": "120px" })) : m("", true), e(p).visible("cuttingHolesJoint") ? (r(), l(a, { key: "cuttingHolesJoint", prop: "cuttingHolesJoint", "show-overflow-tooltip": true, label: "切孔联割(φ) ≥", align: "center", "min-width": "120px" })) : m("", true), e(G)([...e(s).edit, ...e(s).del]) ? (r(), l(a, { key: 3, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: C((I) => {
      var _, O;
      return [b(e(L), { disabledEdit: ((_ = c.layingOffRow) == null ? void 0 : _.name) === "无需套料", disabledDel: ((O = c.layingOffRow) == null ? void 0 : O.name) === "无需套料", data: I.row, permission: e(s) }, null, 8, ["disabledEdit", "disabledDel", "data", "permission"])];
    }), _: 1 })) : m("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[K, e(t).loading]]), b(e(M))], 512), [[k, n.value]])]);
  };
} };
export {
  Y as default
};
