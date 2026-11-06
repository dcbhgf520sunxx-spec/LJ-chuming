import { openBlock as t } from "vue";
import { createElementBlock as m } from "vue";
import { createBlock as a } from "vue";
import { withCtx as i } from "vue";
import { createElementVNode as r } from "vue";
import { toDisplayString as s } from "vue";
import { createCommentVNode as n } from "vue";
import { Fragment as u } from "vue";
import { ElTableColumn as c } from "element-plus";
const f = { __name: "index", props: { columns: { type: Object } }, setup(l) {
  return (p, b) => {
    const o = c;
    return t(), m(u, null, [l.columns.visible("name") ? (t(), a(o, { key: "name", prop: "name", sortable: "custom", "show-overflow-tooltip": true, label: "名称", "min-width": "120px" }, { default: i((e) => [r("span", null, s(e.row.name), 1)]), _: 1 })) : n("", true), l.columns.visible("serialNumber") ? (t(), a(o, { key: "serialNumber", prop: "serialNumber", sortable: "custom", "show-overflow-tooltip": true, label: "编号", "min-width": "140px" }, { default: i((e) => [r("span", null, s(e.row.serialNumber), 1)]), _: 1 })) : n("", true), l.columns.visible("material") ? (t(), a(o, { key: "material", prop: "material", sortable: "custom", "show-overflow-tooltip": true, label: "材质", "min-width": "80px" }, { default: i((e) => [r("span", null, s(e.row.material), 1)]), _: 1 })) : n("", true), l.columns.visible("specification") ? (t(), a(o, { key: "specification", prop: "specification", sortable: "custom", "show-overflow-tooltip": true, label: "规格", "min-width": "140px" }, { default: i((e) => [r("span", null, s(e.row.specification), 1)]), _: 1 })) : n("", true)], 64);
  };
} };
export {
  f as default
};
