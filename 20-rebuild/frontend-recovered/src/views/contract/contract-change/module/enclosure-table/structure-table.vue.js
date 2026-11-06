import { computed as I } from "vue";
import { ref as N } from "vue";
import { resolveComponent as S } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as m } from "vue";
import { createVNode as s } from "vue";
import { withCtx as u } from "vue";
import { createElementVNode as h } from "vue";
import { normalizeStyle as g } from "vue";
import { toDisplayString as y } from "vue";
import { unref as r } from "vue";
import { createBlock as b } from "vue";
import { createCommentVNode as k } from "vue";
import { Fragment as j } from "vue";
import { renderList as B } from "vue";
import { ElTableColumn as E } from "element-plus";
import { j as _ } from "../../../../../modules/judgeSameValue-9683bdce.js";
import { i as c, L as v, iy as A } from "../../../../../shared/runtime.js";
import { _ as x } from "../../../../../modules/index-61ce89a1.js";
const L = { key: 1 }, T = { key: 1 }, z = { key: 0 }, F = ["onClick"], K = { __name: "structure-table", props: { tableData: { type: Array, default: () => [] }, originData: { type: Array, default: () => [] } }, setup($) {
  const p = $, O = I(() => {
    var i;
    const o = [];
    return (i = p.tableData) == null || i.forEach((a) => {
      var d, e, t, V;
      if (a.attachmentId = (d = a.attachments) == null ? void 0 : d.map((n) => n.id).join(","), a.attachmentName = (e = a.attachments) == null ? void 0 : e.map((n) => n.name).join(","), c(p.originData)) if (p.originData.findIndex((n) => n.id === a.id) > -1) {
        const n = p.originData.find((f) => f.id === a.id);
        n.attachmentId = (t = n.attachments) == null ? void 0 : t.map((f) => f.id).join(","), n.attachmentName = (V = n.attachments) == null ? void 0 : V.map((f) => f.name).join(","), _(a, n) ? o.push({ ...a, typeName: "无变更", color: "#909399" }) : o.push({ ...a, originVal: n, typeName: "修改", color: "#e6a23c" });
      } else o.push({ ...a, typeName: "新增", color: "green" });
      else o.push({ ...a, typeName: "新增", color: "green" });
    }), p.originData.forEach((a) => {
      o.findIndex((d) => d.id === a.id) < 0 && o.push({ ...a, typeName: "删除", color: "red" });
    }), o;
  }), w = N(false), D = N();
  function C(o) {
    const i = o.name.split("."), a = i[i.length - 1];
    ["jpg", "png", "pdf", "jpeg"].indexOf(a) > -1 && (D.value = o.id, w.value = true);
  }
  return (o, i) => {
    const a = E, d = S("common-table");
    return l(), m(j, null, [s(d, { data: O.value, "return-source-data": "", showEmptySymbol: false, border: "" }, { default: u(() => [s(a, { label: "序号", type: "index", align: "center", width: "60" }), s(a, { prop: "typeName", label: "变更类型", type: "index", align: "center", width: "60" }, { default: u((e) => [h("span", { style: g(`color:${e.row.color}`) }, y(e.row.typeName), 5)]), _: 1 }), s(a, { prop: "type", "show-overflow-tooltip": true, align: "center", label: "产品种类" }, { default: u((e) => [h("span", { style: g(`color:${r(c)(e.row.originVal) ? "" : e.row.color};`) }, [r(c)(e.row.originVal) && !r(_)(e.row.type, e.row.originVal.type) ? (l(), b(r(x), { key: 0, old: e.row.originVal.type, new: e.row.type }, null, 8, ["old", "new"])) : (l(), m("span", L, y(e.row.type), 1))], 4)]), _: 1 }), s(a, { prop: "techDesc", "show-overflow-tooltip": true, align: "center", label: "技术要求描述" }, { default: u((e) => [h("span", { style: g(`color:${r(c)(e.row.originVal) ? "" : e.row.color};`) }, [r(c)(e.row.originVal) && !r(_)(e.row.techDesc, e.row.originVal.techDesc) ? (l(), b(r(x), { key: 0, old: e.row.originVal.techDesc, new: e.row.techDesc }, null, 8, ["old", "new"])) : (l(), m("span", T, y(e.row.techDesc), 1))], 4)]), _: 1 }), s(a, { prop: "attachments", "show-overflow-tooltip": true, align: "center", label: "附件" }, { default: u((e) => [r(c)(e.row.originVal) && !r(_)(e.row.attachmentId, e.row.originVal.attachmentId) ? (l(), m("div", z, [s(r(x), { old: e.row.originVal.attachmentName, new: e.row.attachmentName }, null, 8, ["old", "new"])])) : k("", true), (l(true), m(j, null, B(e.row.attachments, (t) => (l(), m("div", { key: t.id, style: { "margin-bottom": "2px", "text-align": "left" } }, [h("span", { onClick: (V) => C(t), style: g(`color:${t.name.indexOf(".pdf") > -1 || t.name.indexOf(".png") > -1 || t.name.indexOf(".jpg") > -1 || t.name.indexOf(".jpeg") > -1 ? "#409eff" : ""};cursor:${t.name.indexOf(".pdf") > -1 || t.name.indexOf(".png") > -1 || t.name.indexOf(".jpg") > -1 || t.name.indexOf(".jpeg") > -1 ? "pointer" : ""}`) }, y(t.name), 13, F), s(v, { params: { id: t.id } }, null, 8, ["params"])]))), 128))]), _: 1 })]), _: 1 }, 8, ["data"]), w.value ? (l(), b(A, { key: 0, isVisible: w.value, showType: "attachment", id: D.value, onClose: i[0] || (i[0] = (e) => w.value = false) }, null, 8, ["isVisible", "id"])) : k("", true)], 64);
  };
} };
export {
  K as default
};
