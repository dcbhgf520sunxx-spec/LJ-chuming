import { openBlock as e } from "vue";
import { createElementBlock as r } from "vue";
import { createBlock as l } from "vue";
import { createCommentVNode as a } from "vue";
import { Fragment as m } from "vue";
import { ElTableColumn as s } from "element-plus";
const u = { __name: "index", props: { columns: { type: Object } }, setup(o) {
  return (n, i) => {
    const t = s;
    return e(), r(m, null, [o.columns.visible("name") ? (e(), l(t, { key: "name", prop: "name", sortable: "custom", "show-overflow-tooltip": true, label: "名称", "min-width": "120px" })) : a("", true), o.columns.visible("serialNumber") ? (e(), l(t, { key: "serialNumber", prop: "serialNumber", sortable: "custom", "show-overflow-tooltip": true, label: "编号", "min-width": "140px" })) : a("", true), o.columns.visible("material") ? (e(), l(t, { key: "material", prop: "material", sortable: "custom", "show-overflow-tooltip": true, label: "规格", "min-width": "120px" })) : a("", true)], 64);
  };
} };
export {
  u as default
};
