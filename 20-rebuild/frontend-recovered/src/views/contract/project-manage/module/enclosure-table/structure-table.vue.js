import { ref as u } from "vue";
import { watch as S } from "vue";
import { resolveComponent as _ } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as p } from "vue";
import { createVNode as n } from "vue";
import { withCtx as i } from "vue";
import { createElementVNode as f } from "vue";
import { toDisplayString as m } from "vue";
import { Fragment as y } from "vue";
import { renderList as j } from "vue";
import { normalizeStyle as V } from "vue";
import { createBlock as h } from "vue";
import { createCommentVNode as v } from "vue";
import { ElTableColumn as B } from "element-plus";
import { L as z, iy as E } from "../../../../../shared/runtime.js";
const N = ["onClick"], R = { __name: "structure-table", props: { tableData: { type: Array, default: () => [] }, isShow: { type: Boolean, default: true } }, emits: ["edit"], setup(c, { emit: x }) {
  const b = c, d = u([]);
  S(() => b.tableData, (a) => {
    d.value = b.tableData;
  }, { deep: true, immediate: true });
  const k = x, r = u(false), w = u();
  function C(a) {
    d.value.splice(a, 1);
  }
  function $(a) {
    const l = a.name.split("."), o = l[l.length - 1];
    ["jpg", "png", "pdf", "jpeg"].indexOf(o) > -1 && (w.value = a.id, r.value = true);
  }
  function D(a, l) {
    k("edit", l), d.value.splice(a, 1);
  }
  return (a, l) => {
    const o = B, g = _("common-button"), O = _("common-table");
    return s(), p(y, null, [n(O, { data: c.tableData, "return-source-data": "", showEmptySymbol: false, border: "" }, { default: i(() => [n(o, { label: "序号", type: "index", align: "center", width: "60" }), n(o, { prop: "type", "show-overflow-tooltip": true, align: "center", label: "产品种类" }, { default: i((t) => [f("span", null, m(t.row.type), 1)]), _: 1 }), n(o, { prop: "techDesc", "show-overflow-tooltip": true, align: "center", label: "技术要求描述" }, { default: i((t) => [f("span", null, m(t.row.techDesc), 1)]), _: 1 }), n(o, { prop: "attachments", "show-overflow-tooltip": true, align: "center", label: "附件" }, { default: i((t) => [(s(true), p(y, null, j(t.row.attachments, (e) => (s(), p("div", { key: e.id, style: { "margin-bottom": "2px", "text-align": "left" } }, [f("span", { onClick: (T) => $(e), style: V(`color:${e.name.indexOf(".pdf") > -1 || e.name.indexOf(".png") > -1 || e.name.indexOf(".jpg") > -1 || e.name.indexOf(".jpeg") > -1 ? "#409eff" : ""};cursor:${e.name.indexOf(".pdf") > -1 || e.name.indexOf(".png") > -1 || e.name.indexOf(".jpg") > -1 || e.name.indexOf(".jpeg") > -1 ? "pointer" : ""}`) }, m(e.name), 13, N), n(z, { params: { id: e.id } }, null, 8, ["params"])]))), 128))]), _: 1 }), c.isShow ? v("", true) : (s(), h(o, { key: 0, label: "操作", align: "center" }, { default: i((t) => [n(g, { size: "default", icon: "el-icon-edit", type: "primary", onClick: (e) => D(t.$index, t.row) }, null, 8, ["onClick"]), n(g, { size: "default", icon: "el-icon-delete", type: "danger", onClick: (e) => C(t.$index) }, null, 8, ["onClick"])]), _: 1 }))]), _: 1 }, 8, ["data"]), r.value ? (s(), h(E, { key: 0, isVisible: r.value, showType: "attachment", id: w.value, onClose: l[0] || (l[0] = (t) => r.value = false) }, null, 8, ["isVisible", "id"])) : v("", true)], 64);
  };
} };
export {
  R as default
};
