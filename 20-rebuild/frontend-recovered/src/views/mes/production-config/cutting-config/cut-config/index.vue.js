import { ref as h } from "vue";
import { provide as I } from "vue";
import { inject as J } from "vue";
import { computed as N } from "vue";
import { watch as Q } from "vue";
import { resolveComponent as T } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as V } from "vue";
import { withDirectives as w } from "vue";
import { vShow as k } from "vue";
import { createElementVNode as y } from "vue";
import { createBlock as l } from "vue";
import { withCtx as R } from "vue";
import { createVNode as v } from "vue";
import { unref as e } from "vue";
import { createCommentVNode as m } from "vue";
import { ElTableColumn as j } from "element-plus";
import { vLoading as G } from "element-plus";
import { c as L } from "../../../../../modules/cutting-config-c0cf91cc.js";
import { x as M, oM as s, G as S, an as U } from "../../../../../shared/runtime.js";
import F from "./module/form.vue.js";
const Y = { __name: "index", props: { layingOffRow: { type: Object, default: () => {
} } }, emits: ["click-cut-config"], setup(C, { expose: H, emit: q }) {
  const D = q, u = h(false), b = h(), f = h(), { crud: t, columns: p, CRUD: c } = M({ title: "切割方式配置", sort: [], permission: { ...s }, crudApi: { ...L }, queryOnPresenterCreated: false }, f);
  I("crud", t);
  const A = J("maxHeight"), d = C, n = N(() => d.layingOffRow && d.layingOffRow.id);
  Q(() => n, (o) => {
    o.value && (u.value = true, t.toQuery());
  }, { deep: true, immediate: true });
  function B(o) {
    b.value = o.id, console.log(o, "cutConfig-click"), D("click-cut-config", o);
  }
  function x(o) {
    var i;
    (i = f.value) == null || i.setCurrentRow(o);
  }
  c.HOOK.beforeRefresh = () => (t.query.id = n.value, !!t.query.id), c.HOOK.beforeToQuery = () => (t.query.id = n.value, !!t.query.id), c.HOOK.handleRefresh = (o, i) => {
    i.data.content = i.data.content.map((a, g) => (u.value && g === 0 && x(a), !u.value && b.value === a.id && x(a), a));
  }, c.HOOK.beforeSubmit = () => {
    t.form.layingWayId = n.value;
  };
  function E() {
    u.value = false, t.toQuery();
  }
  return H({ permission: s, refresh: E, toAdd: t.toAdd }), (o, i) => {
    const a = j, g = T("common-table"), K = G;
    return r(), V("div", null, [w(y("div", null, i[0] || (i[0] = [y("div", { class: "my-code" }, "点击下料方式查看详情", -1)]), 512), [[k, !n.value]]), w(y("div", null, [w((r(), l(g, { ref_key: "tableRef", ref: f, data: e(t).data, "highlight-current-row": "", "empty-text": e(t).emptyText, "max-height": e(A) + 92, style: { width: "100%" }, "row-key": "id", onCurrentChange: B }, { default: R(() => [v(a, { label: "序号", type: "index", align: "center", width: "60" }), e(p).visible("name") ? (r(), l(a, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "切割形式", align: "center", "min-width": "120px" })) : m("", true), e(p).visible("thickness") ? (r(), l(a, { key: "thickness", prop: "thickness", "show-overflow-tooltip": true, label: "支持板厚(mm) ≤", align: "center", "min-width": "120px" })) : m("", true), e(p).visible("cuttingHolesJoint") ? (r(), l(a, { key: "cuttingHolesJoint", prop: "cuttingHolesJoint", "show-overflow-tooltip": true, label: "切孔联割(φ) ≥", align: "center", "min-width": "120px" })) : m("", true), e(S)([...e(s).edit, ...e(s).del]) ? (r(), l(a, { key: 3, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: R((P) => {
      var _, O;
      return [v(e(U), { disabledEdit: ((_ = d.layingOffRow) == null ? void 0 : _.name) === "无需套料", disabledDel: ((O = d.layingOffRow) == null ? void 0 : O.name) === "无需套料", data: P.row, permission: e(s) }, null, 8, ["disabledEdit", "disabledDel", "data", "permission"])];
    }), _: 1 })) : m("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[K, e(t).loading]]), v(e(F))], 512), [[k, n.value]])]);
  };
} };
export {
  Y as default
};
