import { iL as l, p as r, e2 as d } from "../shared/runtime.js";
const u = async (a, c) => {
  let e = null;
  const t = [];
  e = a.raw;
  const s = new FormData();
  s.append("file", e), s.append("fileType", 200);
  const o = await c(s), i = r(o.updateTime, "{y}-{m}-{d}");
  if (o.type === 200) {
    const n = { name: o.name, updateTime: i, status: 1 };
    t.push({ ...n }), d("success", "上传成功");
  }
  return { id: o.id, data: t };
};
function m(a) {
  const e = /filename[^;=\n]*=((['"]).*?\2|[^;\n]*)/.exec(a);
  if (e != null && e[1]) {
    const t = e[1].replace(/['"]/g, "");
    return decodeURIComponent(t);
  }
  return null;
}
const f = async (a, c = l) => {
  try {
    const e = await c({ id: a }), t = new Blob([e.data], { type: e.headers["content-type"] }), s = e.headers["content-disposition"] || "", o = m(s), i = window.URL.createObjectURL(t), n = document.createElement("a");
    n.href = i, n.setAttribute("download", o), document.body.appendChild(n), n.click(), window.URL.revokeObjectURL(i), n.remove();
  } catch (e) {
    console.log(e);
  }
};
export {
  f as d,
  u
};
